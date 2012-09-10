package controller;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import converter.UserConverter;
 
import service.FlashcardService;
import service.UserService;

import entity.Flashcard;
import entity.User;

@Controller
@RequestMapping("/card/*")
public class FlashcardController {
 
    @Autowired
    private FlashcardService flashcardSvc;
 
    @Autowired
    private UserService userSvc;
    
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserConverter(this.userSvc));
    }
     
    /**
     * Get a blank page for creating a new flashcard and (for now for convenience) lists existing flashcards
     * 
     * @return
     */
    @RequestMapping(value = "/cards", method=RequestMethod.GET)
    public ModelAndView getFlashcards() {    	
        ModelAndView mav = new ModelAndView("flashcard"); // this will load the view flashcard.jsp
        // now let's add objects to our model
        mav.addObject("flashcard", new Flashcard());    //Empty card
        mav.addObject("userList", userSvc.getUsers());
        mav.addObject("flashcardList", flashcardSvc.getFlashcards());
        return mav;
    }
 
    /**
     * Add a new flashcard
     * 
     * @param flashcard
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFlashcard(@ModelAttribute("flashcard") Flashcard flashcard) {
 
        flashcardSvc.addFlashcard(flashcard);
        return "redirect:/card/cards";
    }

    /**
     * Get the details of a specific flashcard
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("{id}")
    public String getFlashcardDetails(@PathVariable("id") Integer id, Model model) {
  
    	model.addAttribute("id", Integer.toString(id)); 
    	model.addAttribute("flashcard", flashcardSvc.getFlashcard(id));
        return "flashcarddetails";
    }
    
    /**
     * Update an existing flashcard
     * 
     * @param flashcard
     * @return
     */
    @RequestMapping(value = "/update", method=RequestMethod.POST)
    public ModelAndView updateFlashcard(@ModelAttribute("flashcard") Flashcard flashcard) {
    	
    	flashcardSvc.updateFlashcard(flashcard);
    	
    	ModelAndView mav = new ModelAndView("flashcard"); // this will load the view flashcard.jsp
        // now let's add objects to our model
        mav.addObject("flashcard", new Flashcard());    //Empty card
        mav.addObject("userList", userSvc.getUsers());
        mav.addObject("flashcardList", flashcardSvc.getFlashcards());
        
        return mav;
    }
    
    /**
     * Delete an existing flashcard
     * 
     * @param flashcardId
     * @return
     */
    @RequestMapping("/delete/{flashcardId}")
    public String deleteFlashcard(@PathVariable("flashcardId") Integer flashcardId) {
 
        flashcardSvc.deleteFlashcard(flashcardId);
        return "redirect:/card/cards";
    }
    
}