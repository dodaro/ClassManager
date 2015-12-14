package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Event;

public class EventDAOImpl {
	
	public void create(Event event){
		DBHandler.getInstance().create(event);
	}

	public void update(Event event){
		DBHandler.getInstance().update(event);
	}

	public void delete(Event event){
		DBHandler.getInstance().delete(event);
	}

	public Event get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Event event = 
				(Event) session
				.createSQLQuery("SELECT * FROM event WHERE id = " + id)
				.addEntity(Event.class)
				.uniqueResult();
		session.close();
		return event;
	}

	public void deleteAllEvents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Event").executeUpdate();
		session.close();		
	}

	public int numberOfEvents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numEvent= 
				session.createQuery("FROM Event").list().size();
		session.close();
		return numEvent;
	}

	@SuppressWarnings("unchecked")
	public List<Event> getAllEvents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Event> event = 
				session.createQuery("FROM Event").list();
		session.close();
		return event;
	}
	
}
