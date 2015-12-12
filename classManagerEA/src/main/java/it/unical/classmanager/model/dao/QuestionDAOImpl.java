package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Question;

public class QuestionDAOImpl {
	
	public void create(Question question){
		DBHandler.getInstance().create(question);
	}

	public void update(Question question){
		DBHandler.getInstance().update(question);
	}

	public void delete(Question question){
		DBHandler.getInstance().delete(question);		
	}

	public Question get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Question question = 
				(Question) session
				.createSQLQuery("SELECT * FROM question WHERE id = " + id)
				.addEntity(Question.class)
				.uniqueResult();
		session.close();
		return question;
	}

	public void deleteAllQuestions(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Question").executeUpdate();
		session.close();		
	}

	public int numberOfQuestions(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numQuestion= 
				session.createQuery("FROM Question").list().size();
		session.close();
		return numQuestion;
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Question> questions = 
				session.createQuery("FROM Question").list();
		session.close();
		return questions;
	}
	
}