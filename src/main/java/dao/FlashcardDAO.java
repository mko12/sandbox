package dao;

import java.util.List;

import entity.Flashcard;

public interface FlashcardDAO {

	public void addFlashcard(Flashcard card);
	public List<Flashcard> getAllFlashCards();
	public Flashcard getFlashcard(int id);
	public void updateFlashcard(Flashcard card);
	public void deleteFlashcard(int id);
}
