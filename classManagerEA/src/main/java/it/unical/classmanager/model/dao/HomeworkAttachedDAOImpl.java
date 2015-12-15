package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.HomeworkAttached;

public class HomeworkAttachedDAOImpl {
	
	public void create(HomeworkAttached homeworkAttached){
		DBHandler.getInstance().create(homeworkAttached);
	}

	public void update(HomeworkAttached homeworkAttached){
		DBHandler.getInstance().update(homeworkAttached);
	}

	public void delete(HomeworkAttached homeworkAttached){
		DBHandler.getInstance().delete(homeworkAttached);
	}

	public HomeworkAttached get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		HomeworkAttached homeworkAttached = 
				(HomeworkAttached) session
				.createSQLQuery("SELECT * FROM homeworkAttached WHERE id = " + id)
				.addEntity(HomeworkAttached.class)
				.uniqueResult();
		session.close();
		return homeworkAttached;
	}

	public void deleteAllHomeworkAttacheds(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM HomeworkAttached").executeUpdate();
		session.close();		
	}

	public int numberOfHomeworkAttacheds(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numHomeworkAttached= 
				session.createQuery("FROM HomeworkAttached").list().size();
		session.close();
		return numHomeworkAttached;
	}

	@SuppressWarnings("unchecked")
	public List<HomeworkAttached> getAllHomeworkAttacheds(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<HomeworkAttached> homeworkAttached = 
				session.createQuery("FROM HomeworkAttached").list();
		session.close();
		return homeworkAttached;
	}
	
}
