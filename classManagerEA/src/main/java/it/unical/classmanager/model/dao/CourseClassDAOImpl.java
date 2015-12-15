package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.CourseClass;

public class CourseClassDAOImpl {
	
	public void create(CourseClass courseClass){
		DBHandler.getInstance().create(courseClass);
	}

	public void update(CourseClass courseClass){
		DBHandler.getInstance().update(courseClass);
	}

	public void delete(CourseClass courseClass){
		DBHandler.getInstance().delete(courseClass);
	}

	public CourseClass get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		CourseClass courseClass = 
				(CourseClass) session
				.createSQLQuery("SELECT * FROM courseClass WHERE id = " + id)
				.addEntity(CourseClass.class)
				.uniqueResult();
		session.close();
		return courseClass;
	}

	public void deleteAllCourseClasses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM CourseClass").executeUpdate();
		session.close();		
	}

	public int numberOfCourseClasses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numCourseClass= 
				session.createQuery("FROM CourseClass").list().size();
		session.close();
		return numCourseClass;
	}

	@SuppressWarnings("unchecked")
	public List<CourseClass> getAllCourseClassess(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<CourseClass> courseClass = 
				session.createQuery("FROM CourseClass").list();
		session.close();
		return courseClass;
	}

}