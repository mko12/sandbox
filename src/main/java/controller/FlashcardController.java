package controller;
 
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 
	protected static Logger logger = Logger.getLogger("controller");
	
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
    public ModelAndView getFlashcards(Principal principal) {    	
        
    	logger.debug("Received request to show all flashcards");
    	
    	String name = principal.getName();
    	User user = userSvc.getUser(name);
		// Add user to session scope
    	
    	
    	ModelAndView mav = new ModelAndView("flashcard"); // this will load the view flashcard.jsp
        // now let's add objects to our model
        mav.addObject("flashcard", new Flashcard());    //Empty card
        mav.addObject("userList", userSvc.getUsers());
        mav.addObject("username", name);
        if (user != null) {
        	mav.addObject("flashcardList", flashcardSvc.getUserFlashcards(user.getUserId()));		
    	}
    	
     
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
 
    	logger.debug("Received request to add a flashcard");
    	
        flashcardSvc.addFlashcard(flashcard);
        return "redirect:/ihelp/card/cards";
    }

    /**
     * Update a  flashcard
     * 
     * @param flashcard
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateFlashcard(@ModelAttribute("flashcard") Flashcard flashcard) {
    	
    	logger.debug("Received request to update a flashcard");
    	
        flashcardSvc.updateFlashcard(flashcard);
        return "redirect:/ihelp/card/cards";
    }
    
    /**
     * Get the details of a specific flashcard
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/details/{id}", method=RequestMethod.GET)
    public ModelAndView getFlashcardDetails(@PathVariable("id") Integer id) {
  
    	logger.debug("Received request to get flashcard details");
    	
		ModelAndView mav = new ModelAndView("flashcarddetails");
		mav.addObject("id", Integer.toString(id)); 
		mav.addObject("flashcard", flashcardSvc.getFlashcard(id));
		
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
 
    	String debugMessage = "Received request to delete a flashcard with id= " + flashcardId;
    	logger.debug(debugMessage);
    	
        flashcardSvc.deleteFlashcard(flashcardId);
        return "redirect:/ihelp/card/cards";
    }
}