package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.NotificationJSON;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Notification;
import it.unical.classmanager.model.data.Student;
import it.unical.classmanager.model.data.User;

public class NotificationDAOImpl implements NotificationDAO
{
	private DBHandler dbHandler;
	
	@Override
	public void create(Notification notification)
	{
		this.dbHandler.create(notification);
	}

	@Override
	public void update(Notification notification)
	{
		this.dbHandler.update(notification);
	}

	@Override
	public void delete(Notification notification)
	{
		this.dbHandler.delete(notification);
	}

	@Override
	public Notification get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();		  
		Notification notification = (Notification) session.createQuery("FROM Notification "  
			+ "WHERE id = :professor").setParameter("id", id).uniqueResult();;
		session.close();  
		return notification;  
	}

	public DBHandler getDbHandler()
	{
		return dbHandler;
	}

	public void setDbHandler(DBHandler dbHandler)
	{
		this.dbHandler = dbHandler;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NotificationJSON> getNotifications(User user)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();		
		List<NotificationJSON> notifications = session.createQuery("SELECT N.message, N.url, N.date, N.source.username, N.destination.username "
				+ "FROM Notification N "
				+ "WHERE N.destination = :user AND "
					+ "read = false "
				+ "ORDER BY N.date ASC").setParameter("user", user).list();
		session.close();
		return notifications;
	}

	@Override
	public void setNotificationsRead(User user)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();		
		session.createQuery("UPDATE Notification  "
				+ "SET read = true "
				+ "WHERE destination = :user AND" 
					+ "read = false").setParameter("user", user).executeUpdate();
		session.close();
	}
}