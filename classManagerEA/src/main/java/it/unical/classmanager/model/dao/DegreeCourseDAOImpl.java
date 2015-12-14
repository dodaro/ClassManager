package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.DegreeCourse;

public class DegreeCourseDAOImpl {
	
	public void create(DegreeCourse degreeCourse){
		DBHandler.getInstance().create(degreeCourse);
	}

	public void update(DegreeCourse degreeCourse){
		DBHandler.getInstance().update(degreeCourse);
	}

	public void delete(DegreeCourse degreeCourse){
		DBHandler.getInstance().delete(degreeCourse);
	}

	public DegreeCourse get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		DegreeCourse degreeCourse = 
				(DegreeCourse) session
				.createSQLQuery("SELECT * FROM degreeCourse WHERE id = " + id)
				.addEntity(DegreeCourse.class)
				.uniqueResult();
		session.close();
		return degreeCourse;
	}

	public void deleteAllDegreeCourses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM DegreeCourse").executeUpdate();
		session.close();		
	}

	public int numberOfDegreeCourses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numDegreeCourse= 
				session.createQuery("FROM DegreeCourse").list().size();
		session.close();
		return numDegreeCourse;
	}

	@SuppressWarnings("unchecked")
	public List<DegreeCourse> getAllDegreeCourses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<DegreeCourse> degreeCourse = 
				session.createQuery("FROM DegreeCourse").list();
		session.close();
		return degreeCourse;
	}

}