package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}
	
	public User getUser(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where id = :id");
		query.setParameter("id", id);
		return (User)query.uniqueResult();
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void deleteUser(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class,
				id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}

	public User verifyUser(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where username = :username");
		query.setParameter("username", user.getUsername());
		return (User) query.uniqueResult();
	}
}
