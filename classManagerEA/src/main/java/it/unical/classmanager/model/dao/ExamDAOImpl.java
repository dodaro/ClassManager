package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Exam;

public class ExamDAOImpl {
	
	public void create(Exam exam){
		DBHandler.getInstance().create(exam);
	}

	public void update(Exam exam){
		DBHandler.getInstance().update(exam);
	}

	public void delete(Exam exam){
		DBHandler.getInstance().delete(exam);
	}

	public Exam get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Exam exam = 
				(Exam) session
				.createSQLQuery("SELECT * FROM exam WHERE id = " + id)
				.addEntity(Exam.class)
				.uniqueResult();
		session.close();
		return exam;
	}

	public void deleteAllExams(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Exam").executeUpdate();
		session.close();		
	}

	public int numberOfExams(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numExam= 
				session.createQuery("FROM Exam").list().size();
		session.close();
		return numExam;
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Exam> exam = 
				session.createQuery("FROM Exam").list();
		session.close();
		return exam;
	}
	
}