package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.CourseClass;

public class CourseClassDAOImpl {
	private DBHandler dbHandler;

	public void setDbHandler(DBHandler dbHandler)
	{
		this.dbHandler = dbHandler;
	}

	public DBHandler getDbHandler()
	{
		return dbHandler;
	}
	
	public void create(CourseClass courseClass){
		this.dbHandler.create(courseClass);
	}

	public void update(CourseClass courseClass){
		this.dbHandler.update(courseClass);
	}

	public void delete(CourseClass courseClass){
		this.dbHandler.delete(courseClass);
	}

	public CourseClass get(Integer id){
		Session session = this.dbHandler.getSessionFactory().openSession();
		CourseClass courseClass = 
				(CourseClass) session
				.createSQLQuery("SELECT * FROM courseClass WHERE id = " + id)
				.addEntity(CourseClass.class)
				.uniqueResult();
		session.close();
		return courseClass;
	}

	public void deleteAllCourseClasses(){
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM CourseClass").executeUpdate();
		session.close();		
	}

	public int numberOfCourseClasses(){
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numCourseClass= 
				session.createQuery("FROM CourseClass").list().size();
		session.close();
		return numCourseClass;
	}

	@SuppressWarnings("unchecked")
	public List<CourseClass> getAllCourseClassess(){
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<CourseClass> courseClass = 
				session.createQuery("FROM CourseClass").list();
		session.close();
		return courseClass;
	}

}