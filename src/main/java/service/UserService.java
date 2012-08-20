package service;

import java.util.List;

import entity.User;

public interface UserService {

	public void addUser(User user);
	public List<User> getUsers();
	public User getUser(int id);
    public void deleteUser(int id);
       
}
