package service;

import java.util.List;

import utils.LoginStatus;

import entity.User;

public interface UserService {

	public void addUser(User user);
	public List<User> getUsers();
	public User getUser(int id);
	public User getUser(String	username);
	public void updateUser(User user);
    public void deleteUser(int id);
    // @TODO: most likely the rest 3 methods are no longer needed
	public User verifyUser(User user);
	public void setLoginStatus(LoginStatus loginStatus);
	public LoginStatus getLoginStatus();
}
