package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;

public class UserDAOImpl implements UserDAO {

	private DBHandler dbHandler;
	
	public void setDbHandler(DBHandler dbHandler) {
		this.dbHandler = dbHandler;
	}
	
	public DBHandler getDbHandler() {
		return dbHandler;
	}
	
	@Override
	public void create(User user){
		this.dbHandler.create(user);
	}

	@Override
	public void update(User user){
		this.dbHandler.update(user);
	}

	@Override
	public void delete(User user){
		this.dbHandler.delete(user);
	}


	@Override
	public void deleteAllUser(){
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM User").executeUpdate();
		session.close();		
	}

	@Override
	public int numberOfUsers(){
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numUsers = session.createQuery("FROM User").list().size();
		session.close();
		return numUsers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(){
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<User> users = session.createQuery("FROM User").list();
		session.close();
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<Student> students = session.createQuery("FROM Student").list();
		session.close();
		return students;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> getAllProfessors() {
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<Professor> professors = session.createQuery("FROM Professor").list();
		session.close();
		return professors;
	}
	
	@Override
	public User get(String username) {
		Session session = this.dbHandler.getSessionFactory().openSession();
		String queryString = "FROM User WHERE username =:username";
		Query query = session.createQuery(queryString);
		query.setParameter("username",username);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}

	@Override
	public boolean exists(String username) {
		if ( get(username) != null ) 
			return true;
		return false;
	}
	
}


