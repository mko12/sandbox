package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.FlashcardDAO;

import entity.Flashcard;

@Service
public class FlashcardServiceImpl implements FlashcardService {

	@Autowired
	private FlashcardDAO flashcardDAO;
	
	@Transactional
	public void addFlashcard(Flashcard card) {
		flashcardDAO.addFlashcard(card);
	}

	@Transactional
	public List<Flashcard> getFlashcards() {
		return flashcardDAO.getAllFlashCards();
	}

	@Transactional
	public Flashcard getFlashcard(int id) {
		return flashcardDAO.getFlashcard(id);
	}
	
    @Transactional
    public void deleteFlashcard(int id) {
        flashcardDAO.deleteFlashcard(id);
    }

}
