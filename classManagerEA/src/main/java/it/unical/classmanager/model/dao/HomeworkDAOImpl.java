package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.Student;

public class HomeworkDAOImpl implements HomeworkDAO
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

	public void create(Homework homework)
	{
		this.dbHandler.create(homework);
	}

	public void update(Homework homework)
	{
		this.dbHandler.update(homework);
	}

	public void delete(Homework homework)
	{
		this.dbHandler.delete(homework);
	}

	public Homework get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		Homework homework = (Homework) session
				.createSQLQuery("SELECT Homework homework FROM Homework homework WHERE id = " + id)
				.addEntity(Homework.class).uniqueResult();
		session.close();
		return homework;
	}

	public void deleteAllHomeworks()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM Homework homework").executeUpdate();
		session.close();
	}

	public int numberOfHomeworks()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numHomework = session.createQuery("FROM Homework").list().size();
		session.close();
		return numHomework;
	}

	@SuppressWarnings("unchecked")
	public List<Homework> getAllHomeworks()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<Homework> homework = session.createQuery("FROM Homework").list();
		session.close();
		return homework;
	}

}
