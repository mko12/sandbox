package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utils.LoginStatus;

import dao.UserDAO;

import entity.User;

@Service
public class UserServiceImpl implements UserService {

	private LoginStatus loginStatus;
	
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
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    // @TODO - this is no longer needed and will be removed on next check-in
    @Transactional
	public User verifyUser(User user) {
    	
    	User loginUser = userDAO.verifyUser(user);
    	this.setLoginStatus(LoginStatus.UNKNOWN);
    	
    	if (loginUser == null) {
    		this.setLoginStatus(LoginStatus.UKNOWN_USER);
    	} else {
    		if (!user.getPassword().equals(loginUser.getPassword())) {
    			this.setLoginStatus(LoginStatus.WRONG_PASSWORD);
    			loginUser = null;
    		} else {
    			this.setLoginStatus(LoginStatus.SUCCESS);
    		}
    	}
	
    	return loginUser;
	}

    // @TODO: might not need these two anymore either
	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}
}
