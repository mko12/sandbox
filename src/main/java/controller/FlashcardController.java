package controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
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
     
    /**
     * Get a blank page for creating a new flashcard and (for now for convenience) lists existing flashcards
     * 
     * @return
     */
    @RequestMapping(value = "/cards", method=RequestMethod.GET)
    public ModelAndView addFlashcard() {    	
        ModelAndView mav = new ModelAndView("flashcard"); // this will load the view flashcard.jsp
        // now let's add objects to our model
        mav.addObject("flashcard", new Flashcard());    //Empty card
        mav.addObject("userList", userSvc.getUsers());
        mav.addObject("flashcardList", flashcardSvc.getFlashcards());
        return mav;
    }
     
    /**
     * Populates form for creating a new measureInfo
     * 
     * @param measure
     * @param result
     * @param model
     * @return
     */
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addFlashcard(@ModelAttribute("flashcard")
    Flashcard flashcard, BindingResult result) {
 
        flashcardSvc.addFlashcard(flashcard);
        return "redirect:/card/cards";
    }
 
    @RequestMapping("/delete/{flashcardId}")
    public String deleteFlashcard(@PathVariable("flashcardId")
    Integer flashcardId) {
 
        flashcardSvc.deleteFlashcard(flashcardId);
        return "redirect:/card/cards";
    }
    
    @RequestMapping("/details/{id}")
    public String geFlashcardDetails(@PathVariable("id")
    Integer id, Model model) {
  
    	model.addAttribute("id", Integer.toString(id)); 
    	model.addAttribute("flashcard", flashcardSvc.getFlashcard(id));
        return "flashcarddetails";
    }
}