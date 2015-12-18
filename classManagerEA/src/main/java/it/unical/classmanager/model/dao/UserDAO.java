package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.User;

public interface UserDAO {

	public void create(User user);

	public void update(User user);

	public void delete(User user);

	public void deleteAllUser();

	public int numberOfUsers();
	
	public List<User> getAllUsers();
	
	public User get(String username);

	public boolean exists(String username);

}


