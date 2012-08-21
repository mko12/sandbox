package controller;

import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import service.FlashcardService;

import entity.Flashcard;

@Controller
@RequestMapping("/card/*")
public class FlashcardController {
 
    @Autowired
    private FlashcardService flashcardSvc;
 
    @RequestMapping("/cards")
    public String listFlashcards(Map<String, Object> map) {
 
        map.put("flashcard", new Flashcard());
        map.put("flashcardList", flashcardSvc.getFlashcards());
 
        return "flashcard";
    }
 
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
}