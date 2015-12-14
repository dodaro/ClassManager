package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Communications;

public class CommunicationsDAOImpl{
	
	public void create(Communications communications){
		DBHandler.getInstance().create(communications);
	}

	public void update(Communications communications){
		DBHandler.getInstance().update(communications);
	}

	public void delete(Communications communications){
		DBHandler.getInstance().delete(communications);
	}

	public Communications get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Communications communications = 
				(Communications) session
				.createSQLQuery("SELECT * FROM communications WHERE id = " + id)
				.addEntity(Communications.class)
				.uniqueResult();
		session.close();
		return communications;
	}

	public void deleteAllCommunications(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Communications").executeUpdate();
		session.close();		
	}

	public int numberOfCommunications(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numCommunications = 
				session.createQuery("FROM Communications").list().size();
		session.close();
		return numCommunications;
	}

	@SuppressWarnings("unchecked")
	public List<Communications> getAllCommunications(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Communications> communications = 
				session.createQuery("FROM Communications").list();
		session.close();
		return communications;
	}
	
}