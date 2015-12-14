package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.User;

public class UserDAOImpl{

	public void create(User user){
		DBHandler.getInstance().create(user);
	}

	public void update(User user){
		DBHandler.getInstance().update(user);
	}

	public void delete(User user){
		DBHandler.getInstance().delete(user);
	}

	public User get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		User user = (User) session.createSQLQuery("SELECT * FROM user WHERE id = " + id)
				.addEntity(User.class)
				.uniqueResult();
		session.close();
		return user;
	}

	public void deleteAllUser(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM User").executeUpdate();
		session.close();		
	}

	public int numberOfUsers(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numUsers = session.createQuery("FROM User").list().size();
		session.close();
		return numUsers;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<User> users = session.createQuery("FROM User").list();
		session.close();
		return users;
	}
	
}


