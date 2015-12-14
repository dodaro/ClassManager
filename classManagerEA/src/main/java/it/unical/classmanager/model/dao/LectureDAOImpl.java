package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Lecture;

public class LectureDAOImpl {
	
	public void create(Lecture lecture){
		DBHandler.getInstance().create(lecture);
	}

	public void update(Lecture lecture){
		DBHandler.getInstance().update(lecture);
	}

	public void delete(Lecture lecture){
		DBHandler.getInstance().delete(lecture);
	}

	public Lecture get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Lecture lecture = 
				(Lecture) session
				.createSQLQuery("SELECT * FROM lecture WHERE id = " + id)
				.addEntity(Lecture.class)
				.uniqueResult();
		session.close();
		return lecture;
	}

	public void deleteAllLectures(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Lecture").executeUpdate();
		session.close();		
	}

	public int numberOfLectures(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numLecture= 
				session.createQuery("FROM Lecture").list().size();
		session.close();
		return numLecture;
	}

	@SuppressWarnings("unchecked")
	public List<Lecture> getAllLectures(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Lecture> lecture = 
				session.createQuery("FROM Lecture").list();
		session.close();
		return lecture;
	}
	
}
