package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Event;
import it.unical.classmanager.model.data.Lecture;
import it.unical.classmanager.model.data.Professor;

public class CourseClassDAOImpl implements CourseClassDAO {
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
	@Override
	public List<CourseClass> getAllCourseClasses() {
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<CourseClass> courseClass = 
				session.createQuery("FROM CourseClass").list();
		session.close();
		return courseClass;
	}

	@Override
	public List<Lecture> getAllCourseClasses(Professor professor) {
		
		Session session = this.dbHandler.getSessionFactory().openSession();
		Query query = session.createQuery("FROM CourseClass as courseClass WHERE courseClass.professor = :professor");
		query.setParameter("professor", professor);
		
		@SuppressWarnings("unchecked")
		List<Lecture> response = query.list();
		response.size();
		
		session.close();
		
		/*Criteria cr = session.createCriteria(CourseClass.class);
		cr.add(Restrictions.eq("professor", professor));
		
		@SuppressWarnings("unchecked")
		List<CourseClass> results = cr.list();*/
		
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseClass> getCourseClasses(Professor professor)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();		
		List<CourseClass> courseClasses = session.createQuery("FROM CourseClass "
				+ "WHERE professor = :professor").setParameter("professor", professor).list();
		session.close();
		return courseClasses;
	}

}