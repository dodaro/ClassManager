package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.AttendanceStudentLecture;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Lecture;

public class LectureDAOImpl implements LectureDAO
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

	public void create(Lecture lecture)
	{
		this.dbHandler.create(lecture);
	}

	public void update(Lecture lecture)
	{
		this.dbHandler.update(lecture);
	}

	public void delete(Lecture lecture)
	{
		this.dbHandler.delete(lecture);
	}

	public Lecture get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		Lecture lecture = (Lecture) session.createSQLQuery("SELECT * FROM lecture WHERE id = " + id)
				.addEntity(Lecture.class).uniqueResult();
		session.close();
		return lecture;
	}

	public void deleteAllLectures()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM Lecture").executeUpdate();
		session.close();
	}

	public int numberOfLectures()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numLecture = session.createQuery("FROM Lecture").list().size();
		session.close();
		return numLecture;
	}

	@SuppressWarnings("unchecked")
	public List<Lecture> getAllLectures()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<Lecture> lecture = session.createQuery("FROM Lecture").list();
		session.close();
		return lecture;
	}

	@Override
	public Lecture getLastLectureAdded(int idCourse) {

		Session session = this.dbHandler.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Lecture as lecture WHERE lecture.courseClass.id = :id order by lecture.id DESC");
		query.setParameter("id", idCourse);
		query.setMaxResults(1);
		Lecture lecture = (Lecture)query.uniqueResult();

		return lecture;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lecture> getAllLecturesOfACourse(CourseClass course)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();		
		List<Lecture> lecture = session.createQuery("FROM Lecture WHERE courseClass = :course ").setParameter("course", course).list();
		session.close();
		return lecture;
	}

	@Override
	public List<Lecture> getAllLecturesOfACourse(int courseID)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();		
		List<Lecture> lecture = session.createQuery("FROM Lecture WHERE courseClass.id = :course ").setParameter("course", courseID).list();
		session.close();
		return lecture;
	}
}
