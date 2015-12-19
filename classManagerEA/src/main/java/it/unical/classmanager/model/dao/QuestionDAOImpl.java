package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Question;

public class QuestionDAOImpl implements QuestionDAO
{
	private DBHandler dbHandler;

	public void setDbHandler(DBHandler dbHandler)
	{
		this.dbHandler = dbHandler;
	}

	public DBHandler getDbHandler()
	{
		return dbHandler;
	}

	public void create(Question question)
	{
		this.dbHandler.create(question);
	}

	public void update(Question question)
	{
		this.dbHandler.update(question);
	}

	public void delete(Question question)
	{
		this.dbHandler.delete(question);
	}

	public Question get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		Question question = (Question) session.createSQLQuery("SELECT * FROM question WHERE id = " + id)
				.addEntity(Question.class).uniqueResult();
		session.close();
		return question;
	}

	public void deleteAllQuestions()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM Question").executeUpdate();
		session.close();
	}

	public int numberOfQuestions()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numQuestion = session.createQuery("FROM Question").list().size();
		session.close();
		return numQuestion;
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<Question> questions = session.createQuery("FROM Question").list();
		session.close();
		return questions;
	}

}