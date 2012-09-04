package service;

import java.util.List;

import utils.LoginStatus;

import entity.User;

public interface UserService {

	public void addUser(User user);
	public List<User> getUsers();
	public User getUser(int id);
	public void updateUser(User user);
    public void deleteUser(int id);
	public User verifyUser(User user);
	public void setLoginStatus(LoginStatus loginStatus);
	public LoginStatus getLoginStatus();
}
