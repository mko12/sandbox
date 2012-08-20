package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAO;

import entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Transactional
	public List<User> getUsers() {
		return userDAO.getAllUsers();
	}

	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}
	
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

}
