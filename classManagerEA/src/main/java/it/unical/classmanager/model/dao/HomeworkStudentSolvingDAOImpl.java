package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.HomeworkStudentSolving;

public class HomeworkStudentSolvingDAOImpl {
	
	public void create(HomeworkStudentSolving homeworkStudentSolving){
		DBHandler.getInstance().create(homeworkStudentSolving);
	}

	public void update(HomeworkStudentSolving homeworkStudentSolving){
		DBHandler.getInstance().update(homeworkStudentSolving);
	}

	public void delete(HomeworkStudentSolving homeworkStudentSolving){
		DBHandler.getInstance().delete(homeworkStudentSolving);
	}

	public HomeworkStudentSolving get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		HomeworkStudentSolving homeworkStudentSolving = 
				(HomeworkStudentSolving) session
				.createSQLQuery("SELECT * FROM homeworkStudentSolving WHERE id = " + id)
				.addEntity(HomeworkStudentSolving.class)
				.uniqueResult();
		session.close();
		return homeworkStudentSolving;
	}

	public void deleteAllHomeworkStudentSolvings(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM HomeworkStudentSolving").executeUpdate();
		session.close();		
	}

	public int numberOfHomeworkStudentSolvings(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numHomeworkStudentSolving= 
				session.createQuery("FROM HomeworkStudentSolving").list().size();
		session.close();
		return numHomeworkStudentSolving;
	}

	@SuppressWarnings("unchecked")
	public List<HomeworkStudentSolving> getAllHomeworkStudentSolvings(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<HomeworkStudentSolving> homeworkStudentSolving = 
				session.createQuery("FROM HomeworkStudentSolving").list();
		session.close();
		return homeworkStudentSolving;
	}
	
}
