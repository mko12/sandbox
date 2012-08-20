package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Flashcard;

@Repository
public class FlashcardDAOImpl implements FlashcardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addFlashcard(Flashcard card) {
		sessionFactory.getCurrentSession().save(card);
	}


	public List<Flashcard> getAllFlashCards() {
		return sessionFactory.getCurrentSession().createQuery("from Flashcard").list();
	}


	public Flashcard getFlashcard(int id) {
		
		Flashcard card = (Flashcard)sessionFactory.getCurrentSession().load(Flashcard.class, id);
		return card; 
	}
	
	public void deleteFlashcard(int id) {
		Flashcard flashcard = (Flashcard) sessionFactory.getCurrentSession()
				.load(Flashcard.class, id);
		if (null != flashcard) {
			sessionFactory.getCurrentSession().delete(flashcard);
		}

	}

}
