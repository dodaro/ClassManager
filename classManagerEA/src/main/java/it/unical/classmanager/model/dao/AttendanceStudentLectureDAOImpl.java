package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.AttendanceStudentLecture;

public class AttendanceStudentLectureDAOImpl {
	
	public void create(AttendanceStudentLecture attendanceStudentLecture){
		DBHandler.getInstance().create(attendanceStudentLecture);
	}

	public void update(AttendanceStudentLecture attendanceStudentLecture){
		DBHandler.getInstance().update(attendanceStudentLecture);
	}

	public void delete(AttendanceStudentLecture attendanceStudentLecture){
		DBHandler.getInstance().delete(attendanceStudentLecture);
	}

	public AttendanceStudentLecture get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		AttendanceStudentLecture attendanceStudentLecture = 
				(AttendanceStudentLecture) session
				.createSQLQuery("SELECT * FROM attendanceStudentLecture WHERE id = " + id)
				.addEntity(AttendanceStudentLecture.class)
				.uniqueResult();
		session.close();
		return attendanceStudentLecture;
	}

	public void deleteAllAttendanceStudentLectures(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM AttendanceStudentLecture").executeUpdate();
		session.close();		
	}

	public int numberOfAttendanceStudentLectures(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numAttendanceStudentLecture= 
				session.createQuery("FROM AttendanceStudentLecture").list().size();
		session.close();
		return numAttendanceStudentLecture;
	}

	@SuppressWarnings("unchecked")
	public List<AttendanceStudentLecture> getAllAttendanceStudentLectures(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<AttendanceStudentLecture> attendanceStudentLecture = 
				session.createQuery("FROM AttendanceStudentLecture").list();
		session.close();
		return attendanceStudentLecture;
	}

}