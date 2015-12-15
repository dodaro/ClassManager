package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.AttendanceStudentLecture;

public class AttendanceStudentLectureDAOImpl
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

	public void create(AttendanceStudentLecture attendanceStudentLecture)
	{
		this.dbHandler.create(attendanceStudentLecture);
	}

	public void update(AttendanceStudentLecture attendanceStudentLecture)
	{
		this.dbHandler.update(attendanceStudentLecture);
	}

	public void delete(AttendanceStudentLecture attendanceStudentLecture)
	{
		this.dbHandler.delete(attendanceStudentLecture);
	}

	public AttendanceStudentLecture get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		AttendanceStudentLecture attendanceStudentLecture = (AttendanceStudentLecture) session
				.createSQLQuery("SELECT * FROM attendanceStudentLecture WHERE id = " + id)
				.addEntity(AttendanceStudentLecture.class).uniqueResult();
		session.close();
		return attendanceStudentLecture;
	}

	public void deleteAllAttendanceStudentLectures()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM AttendanceStudentLecture").executeUpdate();
		session.close();
	}

	public int numberOfAttendanceStudentLectures()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numAttendanceStudentLecture = session.createQuery("FROM AttendanceStudentLecture").list().size();
		session.close();
		return numAttendanceStudentLecture;
	}

	@SuppressWarnings("unchecked")
	public List<AttendanceStudentLecture> getAllAttendanceStudentLectures()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<AttendanceStudentLecture> attendanceStudentLecture = session.createQuery("FROM AttendanceStudentLecture")
				.list();
		session.close();
		return attendanceStudentLecture;
	}

}