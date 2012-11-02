package dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.UserRole;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().save(userRole);
	}

	public void deleteUserRole(int userRoleId) {
		UserRole userRole = (UserRole) sessionFactory.getCurrentSession().load(UserRole.class,
				userRoleId);
		if (null != userRole) {
			sessionFactory.getCurrentSession().delete(userRole);
		}
	}
	
	public UserRole getUserRole(int userRoleId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User_Role where id = :id");
		query.setParameter("id", userRoleId);
		return (UserRole)query.uniqueResult();
	}
}
