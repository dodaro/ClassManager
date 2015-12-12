package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.AnswerAttachedContent;

public class AnswerAttachedContentDAOImpl {
	
	public void create(AnswerAttachedContent answerAttachedContent){
		DBHandler.getInstance().create(answerAttachedContent);
	}

	public void update(AnswerAttachedContent answerAttachedContent){
		DBHandler.getInstance().update(answerAttachedContent);
	}

	public void delete(AnswerAttachedContent answerAttachedContent){
		DBHandler.getInstance().delete(answerAttachedContent);
	}

	public AnswerAttachedContent get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		AnswerAttachedContent answerAttachedContent = 
				(AnswerAttachedContent) session
				.createSQLQuery("SELECT answerAttachedContent FROM AnswerAttachedContent answerAttachedContent WHERE id = " + id)
				.addEntity(AnswerAttachedContent.class)
				.uniqueResult();
		session.close();
		return answerAttachedContent;
	}

	public void deleteAllAnswerAttachedContents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM AnswerAttachedContent").executeUpdate();
		session.close();		
	}

	public int numberOfAnswerAttachedContents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numAnswerAttachedContent= 
				session.createQuery("FROM AnswerAttachedContent").list().size();
		session.close();
		return numAnswerAttachedContent;
	}

	@SuppressWarnings("unchecked")
	public List<AnswerAttachedContent> getAllAnswerAttachedContents(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<AnswerAttachedContent> answerAttachedContents = 
				session.createQuery("FROM AnswerAttachedContent").list();
		session.close();
		return answerAttachedContents;
	}

}