package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.StudentExamPartecipation;

public class StudentExamPartecipationDAOImpl {

	public void create(StudentExamPartecipation studentExamPartecipation){
		DBHandler.getInstance().create(studentExamPartecipation);
	}

	public void update(StudentExamPartecipation studentExamPartecipation){
		DBHandler.getInstance().update(studentExamPartecipation);
	}

	public void delete(StudentExamPartecipation studentExamPartecipation){
		DBHandler.getInstance().delete(studentExamPartecipation);
	}

	public StudentExamPartecipation get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		StudentExamPartecipation studentExamPartecipation = 
				(StudentExamPartecipation) session
				.createSQLQuery("SELECT * FROM studentExamPartecipation WHERE id = " + id)
				.addEntity(StudentExamPartecipation.class)
				.uniqueResult();
		session.close();
		return studentExamPartecipation;
	}

	public void deleteAllStudentExamPartecipations(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM StudentExamPartecipation").executeUpdate();
		session.close();		
	}

	public int numberOfStudentExamPartecipations(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numStudentExamPartecipations = 
				session.createQuery("FROM StudentExamPartecipation").list().size();
		session.close();
		return numStudentExamPartecipations;
	}

	@SuppressWarnings("unchecked")
	public List<StudentExamPartecipation> getAllStudentExamPartecipations(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<StudentExamPartecipation> studentExamPartecipations = 
				session.createQuery("FROM StudentExamPartecipation").list();
		session.close();
		return studentExamPartecipations;
	}
	
}