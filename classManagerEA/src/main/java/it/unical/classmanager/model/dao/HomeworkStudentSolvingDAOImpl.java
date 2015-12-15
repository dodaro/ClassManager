package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.HomeworkStudentSolving;

public class HomeworkStudentSolvingDAOImpl
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

	public void create(HomeworkStudentSolving homeworkStudentSolving)
	{
		this.dbHandler.create(homeworkStudentSolving);
	}

	public void update(HomeworkStudentSolving homeworkStudentSolving)
	{
		this.dbHandler.update(homeworkStudentSolving);
	}

	public void delete(HomeworkStudentSolving homeworkStudentSolving)
	{
		this.dbHandler.delete(homeworkStudentSolving);
	}

	public HomeworkStudentSolving get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		HomeworkStudentSolving homeworkStudentSolving = (HomeworkStudentSolving) session
				.createSQLQuery("SELECT * FROM homeworkStudentSolving WHERE id = " + id)
				.addEntity(HomeworkStudentSolving.class).uniqueResult();
		session.close();
		return homeworkStudentSolving;
	}

	public void deleteAllHomeworkStudentSolvings()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM HomeworkStudentSolving").executeUpdate();
		session.close();
	}

	public int numberOfHomeworkStudentSolvings()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numHomeworkStudentSolving = session.createQuery("FROM HomeworkStudentSolving").list().size();
		session.close();
		return numHomeworkStudentSolving;
	}

	@SuppressWarnings("unchecked")
	public List<HomeworkStudentSolving> getAllHomeworkStudentSolvings()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<HomeworkStudentSolving> homeworkStudentSolving = session.createQuery("FROM HomeworkStudentSolving").list();
		session.close();
		return homeworkStudentSolving;
	}

}
