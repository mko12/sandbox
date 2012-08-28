package service;

import java.util.List;

import entity.Flashcard;

public interface FlashcardService {

	public void addFlashcard(Flashcard card);
	public List<Flashcard> getFlashcards();
	public Flashcard getFlashcard(int id);
	public void updateFlashcard(Flashcard card);
    public void deleteFlashcard(int id);
       
}
