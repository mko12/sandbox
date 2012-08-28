package dao;

import java.util.List;

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
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User getUser(int id) {
		
		User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
		return user; 
	}
	
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	public void deleteUser(int id) {
		User user = (User) sessionFactory.getCurrentSession()
				.load(User.class, id);
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}

	}
}
