package it.unical.classmanager.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAO {
	
	private DBHandler dbHandler;
	
	public UserDAO() {
	}
	
	public void create(User user) {
		dbHandler.create(user);
	}
	
	public void update(User user) {
		dbHandler.update(user);
	}
	
	public void delete(User user) {
		dbHandler.delete(user);
	}
	
	public void setDbHandler(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}
	
	public DBHandler getDbHandler() {
		return dbHandler;
	}
	
	public void deleteAllUser() {
		Session session = dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM User").executeUpdate();
		session.close();
	}
	
	public List<User> getAllUsers() {
		Session session = dbHandler.getSessionFactory().openSession();
		ArrayList<User> users = (ArrayList<User>) session.createQuery("FROM User").list();
		session.close();
		return users;
	}

	public User getUser(String username) {
		Session session = dbHandler.getSessionFactory().openSession();
		String queryString = "FROM User where username = :_username";
		Query query = session.createQuery(queryString);
		query.setParameter("_username", username);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}

}