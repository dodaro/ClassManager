package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.Lecture;
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

		Query finalQuery = session.createQuery("FROM Homework as h WHERE h.id = :id)");
		finalQuery.setParameter("id", id);
		Homework homework = (Homework) finalQuery.uniqueResult();
		
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

	@SuppressWarnings("unchecked")
	public List<Homework> getAllHomeworks(int idCourse)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();

		Query finalQuery = session.createQuery("FROM Homework as h WHERE h.lecture.courseClass IN (FROM CourseClass as course WHERE course.id = :id)");
		finalQuery.setParameter("id", idCourse);
		List<Homework> homeworks = finalQuery.list();

		for (Homework homework : homeworks) {
			homework.getHomeworkStudentSolvings().size();
		}

		//Cannot manages multiple bags
		//selects all the courses with "id" equals to "idCourse"
		/*DetachedCriteria courseCriteria = DetachedCriteria.forClass(CourseClass.class,"course")
				.add(Restrictions.eq("id", idCourse));

		//selects all the homeworks where the associated lecture belong to the course selected before
		List<Homework> homework = (List<Homework>) session.createCriteria(Homework.class,"homework")
				.add(Subqueries.in("homework.lecture", courseCriteria));
		 */

		session.close();
		return homeworks;
	}

	@Override
	public List<Homework> getAllLectureHomeworks(int idLecture) {
		
		Session session = this.dbHandler.getSessionFactory().openSession();

		Query finalQuery = session.createQuery("FROM Homework as h WHERE h.lecture.id = :id");
		finalQuery.setParameter("id", idLecture);
		List<Homework> homeworks = finalQuery.list();
		
		return homeworks;

	}

}
