package dao;

import java.util.List;

import org.hibernate.Query;
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

	public List<Flashcard> getUserFlashCards(int userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Flashcard where userid = :id");
		query.setParameter("id", userId);
		return query.list();
	}
	
	public Flashcard getFlashcard(int cardId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Flashcard where id = :id");
		query.setParameter("id", cardId);
		return (Flashcard)query.uniqueResult();
	}
	
	public void updateFlashcard(Flashcard card) {
		sessionFactory.getCurrentSession().update(card);
	}

	public void deleteFlashcard(int id) {
		Flashcard flashcard = (Flashcard) sessionFactory.getCurrentSession()
				.load(Flashcard.class, id);
		if (null != flashcard) {
			sessionFactory.getCurrentSession().delete(flashcard);
		}
	}
}
