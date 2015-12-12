package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.QuestionAttachedContent;


public class QuestionAttachedContentDAOImpl {
	
	public void create(QuestionAttachedContent questionAttachedContent){
		DBHandler.getInstance().create(questionAttachedContent);
	}

	public void update(QuestionAttachedContent questionAttachedContent){
		DBHandler.getInstance().update(questionAttachedContent);
	}

	public void delete(QuestionAttachedContent questionAttachedContent){
		DBHandler.getInstance().delete(questionAttachedContent);
	}

	public QuestionAttachedContent get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		QuestionAttachedContent questionAttachedContent = 
				(QuestionAttachedContent) session
				.createSQLQuery("SELECT * FROM questionAttachedContent WHERE id = " + id)
				.addEntity(QuestionAttachedContent.class)
				.uniqueResult();
		session.close();
		return questionAttachedContent;
	}

	public void deleteAllQuestionAttachedContents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM QuestionAttachedContent").executeUpdate();
		session.close();		
	}

	public int numberOfQuestionAttachedContents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numQuestion= 
				session.createQuery("FROM QuestionAttachedContent").list().size();
		session.close();
		return numQuestion;
	}

	@SuppressWarnings("unchecked")
	public List<QuestionAttachedContent> getAllQuestionAttachedContents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<QuestionAttachedContent> questionAttachedContents = 
				session.createQuery("FROM QuestionAttachedContent").list();
		session.close();
		return questionAttachedContents;
	}

}