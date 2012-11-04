package dao;

import java.util.List;

import entity.User;

public interface UserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userId);
	public User verifyUser(User user);
	public User getUser(int userId);
	public User getUser(String username);
	public List<User> getAllUsers();
}
