package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Answer;

public class AnswerDAOImpl {
	
	public void create(Answer answer){
		DBHandler.getInstance().create(answer);
	}

	public void update(Answer answer){
		DBHandler.getInstance().update(answer);
	}

	public void delete(Answer answer){
		DBHandler.getInstance().delete(answer);
	}

	public Answer get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Answer answer = 
				(Answer) session
				.createSQLQuery("SELECT * FROM answer WHERE id = " + id)
				.addEntity(Answer.class)
				.uniqueResult();
		session.close();
		return answer;
	}

	public void deleteAllAnswers(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Answer").executeUpdate();
		session.close();		
	}

	public int numberOfAnswers(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numAnswer = 
				session.createQuery("FROM Answer").list().size();
		session.close();
		return numAnswer;
	}

	@SuppressWarnings("unchecked")
	public List<Answer> getAllAnswers(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Answer> answer = 
				session.createQuery("FROM Answer").list();
		session.close();
		return answer;
	}
}