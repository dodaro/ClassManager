package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Homework;

public class HomeworkDAOImpl {
	
	public void create(Homework homework){
		DBHandler.getInstance().create(homework);
	}

	public void update(Homework homework){
		DBHandler.getInstance().update(homework);
	}

	public void delete(Homework homework){
		DBHandler.getInstance().delete(homework);
	}

	public Homework get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Homework homework = 
				(Homework) session
				.createSQLQuery("SELECT Homework homework FROM Homework homework WHERE id = " + id)
				.addEntity(Homework.class)
				.uniqueResult();
		session.close();
		return homework;
	}

	public void deleteAllHomeworks(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Homework homework").executeUpdate();
		session.close();		
	}

	public int numberOfHomeworks(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numHomework= 
				session.createQuery("FROM Homework").list().size();
		session.close();
		return numHomework;
	}

	@SuppressWarnings("unchecked")
	public List<Homework> getAllHomeworks(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Homework> homework = 
				session.createQuery("FROM Homework").list();
		session.close();
		return homework;
	}
	
}
