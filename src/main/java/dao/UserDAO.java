package dao;

import java.util.List;

import entity.User;

public interface UserDAO {

	public void addUser(User user);
	public List<User> getAllUsers();
	public User getUser(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User verifyUser(User user);
}
