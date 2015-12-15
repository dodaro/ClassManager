package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.HomeworkAttachedStudentSolving;

public class HomeworkAttachedStudentSolvingDAOImpl {
	
	public void create(HomeworkAttachedStudentSolving homeworkAttachedStudentSolving){
		DBHandler.getInstance().create(homeworkAttachedStudentSolving);
	}

	public void update(HomeworkAttachedStudentSolving homeworkAttachedStudentSolving){
		DBHandler.getInstance().update(homeworkAttachedStudentSolving);
	}

	public void delete(HomeworkAttachedStudentSolving homeworkAttachedStudentSolving){
		DBHandler.getInstance().delete(homeworkAttachedStudentSolving);
	}

	public HomeworkAttachedStudentSolving get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		HomeworkAttachedStudentSolving homeworkAttachedStudentSolving = 
				(HomeworkAttachedStudentSolving) session
				.createSQLQuery("SELECT * FROM homeworkAttachedStudentSolving WHERE id = " + id)
				.addEntity(HomeworkAttachedStudentSolving.class)
				.uniqueResult();
		session.close();
		return homeworkAttachedStudentSolving;
	}

	public void deleteAllHomeworkAttachedStudentSolvings(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM HomeworkAttachedStudentSolving").executeUpdate();
		session.close();		
	}

	public int numberOfHomeworkAttachedStudentSolvings(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numHomeworkAttachedStudentSolving= 
				session.createQuery("FROM HomeworkAttachedStudentSolving").list().size();
		session.close();
		return numHomeworkAttachedStudentSolving;
	}

	@SuppressWarnings("unchecked")
	public List<HomeworkAttachedStudentSolving> getAllHomeworkAttachedStudentSolvings(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<HomeworkAttachedStudentSolving> homeworkAttachedStudentSolving = 
				session.createQuery("FROM HomeworkAttachedStudentSolving").list();
		session.close();
		return homeworkAttachedStudentSolving;
	}

}