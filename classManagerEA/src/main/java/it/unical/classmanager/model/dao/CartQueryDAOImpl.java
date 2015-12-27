package it.unical.classmanager.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.Student;

/**
 * @author Aloisius92
 * This is a DAO for perform queries related to statistics.
 * This is the implementation.
 */
public class CartQueryDAOImpl implements CartQueryDAO
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
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getCourseByProfessor(Professor professor)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getCourseByProfessor( Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();	
	
	/*
	 * Professor, NumberCourse
	 * Professor, numberCourse
	 * Professor, numberCourse
	 * Professor, numberCourse
	 * 
	 */
	
	// Dummy data
	//	Object[] res1 = {"Professor1", 4};
	//	Object[] res2 = {"Professor2", 2};
	//	Object[] res3 = {"Professor3", 1};	
	//	Object[] res4 = {"Professor4", 3};
	//	Object[] res5 = {"Professor5", 2};
	//	Object[] res6 = {"Professor6", 4};
	//	result.add(res1);	
	//	result.add(res2);	
	//	result.add(res3);
	//	result.add(res4);	
	//	result.add(res5);	
	//	result.add(res6);
	
	// Query execution
	/*
	 * select C.professor, count(*)
	 * from CourseClass C
	 * group by C.professor
	 */
	Session session = DaoHelper.getDbHandler().getSessionFactory().openSession();
	String hql = "SELECT C.professor.username, count(*) "
		+ "FROM CourseClass C "
		+ "GROUP BY C.professor";
	Query query = session.createQuery(hql);
	result = query.list();
	session.close();
	
	System.err.println("getCourseByProfessor(professor)");
	for(int i=0; i<result.size(); i++){
	    Object[] objects = result.get(i);
	    System.out.println("Prof: "+objects[0]+", NumCourse: "+objects[1]);
	}
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getForYearLectureByWeekDaySingleProfessor( Professor professor)
     */
    @Override
    public List<Object[]> getForYearLectureByWeekDay(Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * 2012, Monday, NumberLecture
	 * 2012, Tuesday, NumberLecture
	 * 2012, Wednesday, NumberLecture
	 * 2012, Thursday, NumberLecture
	 * 2012, Friday, NumberLecture
	 * 2012, Saturday, NumberLecture
	 * 2012, Sunday, NumberLecture
	 * 2013, Monday, NumberLecture
	 * 2013, Tuesday, NumberLecture
	 * 2013, Wednesday, NumberLecture
	 * 2013, Thursday, NumberLecture
	 * 2013, Friday, NumberLecture
	 * 2013, Saturday, NumberLecture
	 * 2013, Sunday, NumberLecture
	 * 2014, Monday, NumberLecture
	 * 2014, Tuesday, NumberLecture
	 * 2014, Wednesday, NumberLecture
	 * 2014, Thursday, NumberLecture
	 * 2014, Friday, NumberLecture
	 * 2014, Saturday, NumberLecture
	 * 2014, Sunday, NumberLecture
	 * 
	 */
	
	Object[] res11 = {2012, "Monday", 40};
	Object[] res12 = {2012, "Tuesday", 38};
	Object[] res13 = {2012, "Wednesday", 26};	
	Object[] res14 = {2012, "Thursday", 24};
	Object[] res15 = {2012, "Friday", 26};
	Object[] res16 = {2012, "Saturday", 30};
	Object[] res17 = {2012, "Sunday", 0};
	result.add(res11);	
	result.add(res12);	
	result.add(res13);
	result.add(res14);	
	result.add(res15);	
	result.add(res16);	
	result.add(res17);
	Object[] res21 = {2013, "Monday", 40};
	Object[] res22 = {2013, "Tuesday", 38};
	Object[] res23 = {2013, "Wednesday", 26};	
	Object[] res24 = {2013, "Thursday", 24};
	Object[] res25 = {2013, "Friday", 26};
	Object[] res26 = {2013, "Saturday", 30};
	Object[] res27 = {2013, "Sunday", 0};
	result.add(res21);	
	result.add(res22);	
	result.add(res23);
	result.add(res24);	
	result.add(res25);	
	result.add(res26);	
	result.add(res27);
	Object[] res31 = {2014, "Monday", 40};
	Object[] res32 = {2014, "Tuesday", 38};
	Object[] res33 = {2014, "Wednesday", 26};	
	Object[] res34 = {2014, "Thursday", 24};
	Object[] res35 = {2014, "Friday", 26};
	Object[] res36 = {2014, "Saturday", 30};
	Object[] res37 = {2014, "Sunday", 0};
	result.add(res31);	
	result.add(res32);	
	result.add(res33);
	result.add(res34);	
	result.add(res35);	
	result.add(res36);	
	result.add(res37);
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgLectureByWeekDaySingleProfessor( Professor professor)
     */
    @Override
    public List<Object[]> getAvgLectureByWeekDaySingleProfessor( Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	/*
	 * Monday, NumberLecture
	 * Tuesday, NumberLecture
	 * Wednesday, NumberLecture
	 * Thursday, NumberLecture
	 * Friday, NumberLecture
	 * Saturday, NumberLecture
	 * Sunday, NumberLecture
	 * 
	 */
	
	Object[] res1 = {"Monday", 40};
	Object[] res2 = {"Tuesday", 38};
	Object[] res3 = {"Wednesday", 26};	
	Object[] res4 = {"Thursday", 24};
	Object[] res5 = {"Friday", 26};
	Object[] res6 = {"Saturday", 30};
	Object[] res7 = {"Sunday", 0};
	result.add(res1);	
	result.add(res2);	
	result.add(res3);
	result.add(res4);	
	result.add(res5);	
	result.add(res6);	
	result.add(res7);
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgLectureByWeekDayAllProfessor( List<Professor> professors)
     */
    @Override
    public List<Object[]> getAvgLectureByWeekDayAllProfessor( List<Professor> professors) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * Professor, Monday, NumberLecture
	 * Professor, Tuesday, NumberLecture
	 * Professor, Wednesday, NumberLecture
	 * Professor, Thursday, NumberLecture
	 * Professor, Friday, NumberLecture
	 * Professor, Saturday, NumberLecture
	 * Professor, Sunday, NumberLecture
	 * 
	 */
	
	// Professor1
	Object[] professor1_11 = {"Professor1" , "Monday", 40};
	Object[] professor1_12 = {"Professor1" , "Tuesday", 38};
	Object[] professor1_13 = {"Professor1" , "Wednesday", 26};	
	Object[] professor1_14 = {"Professor1" , "Thursday", 24};
	Object[] professor1_15 = {"Professor1" , "Friday", 26};
	Object[] professor1_16 = {"Professor1" , "Saturday", 30};
	Object[] professor1_17 = {"Professor1" , "Sunday", 0};
	result.add(professor1_11);	
	result.add(professor1_12);	
	result.add(professor1_13);
	result.add(professor1_14);	
	result.add(professor1_15);	
	result.add(professor1_16);	
	result.add(professor1_17);
	
	// Professor2
	Object[] professor2_11 = {"professor2" , "Monday", 60};
	Object[] professor2_12 = {"professor2" , "Tuesday", 28};
	Object[] professor2_13 = {"professor2" , "Wednesday", 16};	
	Object[] professor2_14 = {"professor2" , "Thursday", 25};
	Object[] professor2_15 = {"professor2" , "Friday", 23};
	Object[] professor2_16 = {"professor2" , "Saturday", 40};
	Object[] professor2_17 = {"professor2" , "Sunday", 0};
	result.add(professor2_11);	
	result.add(professor2_12);	
	result.add(professor2_13);
	result.add(professor2_14);	
	result.add(professor2_15);	
	result.add(professor2_16);	
	result.add(professor2_17);
	
	// Professor3
	Object[] professor3_11 = {"professor3" , "Monday", 10};
	Object[] professor3_12 = {"professor3" , "Tuesday", 18};
	Object[] professor3_13 = {"professor3" , "Wednesday", 16};	
	Object[] professor3_14 = {"professor3" , "Thursday", 14};
	Object[] professor3_15 = {"professor3" , "Friday", 16};
	Object[] professor3_16 = {"professor3" , "Saturday", 10};
	Object[] professor3_17 = {"professor3" , "Sunday", 0};
	result.add(professor3_11);	
	result.add(professor3_12);	
	result.add(professor3_13);
	result.add(professor3_14);	
	result.add(professor3_15);	
	result.add(professor3_16);	
	result.add(professor3_17);
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgTimeDeliveryHomework( Professor professor)
     */
    @Override
    public List<Object[]> getAvgTimeDeliveryHomework(Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * CourseClass, Student, AvgTime
	 * CourseClass, Student, AvgTime
	 * CourseClass, Student, AvgTime
	 */
	
	// Select only the course of the professor	
	Object[] res11 = {"Course1", "Student1", 4};
	Object[] res21 = {"Course1", "Student2", 2};
	Object[] res31 = {"Course1", "Student3", 1};	
	Object[] res41 = {"Course1", "Student4", 3};
	Object[] res51 = {"Course1", "Student5", 2};
	Object[] res61 = {"Course1", "Student6", 4};
	result.add(res11);	
	result.add(res21);	
	result.add(res31);
	result.add(res41);	
	result.add(res51);	
	result.add(res61);
	Object[] res12 = {"Course2", "Student1", 6};
	Object[] res22 = {"Course2", "Student2", 8};
	Object[] res32 = {"Course2", "Student3", 9};	
	Object[] res42 = {"Course2", "Student4", 2};
	Object[] res52 = {"Course2", "Student5", 1};
	Object[] res62 = {"Course2", "Student6", 2};
	result.add(res12);	
	result.add(res22);	
	result.add(res32);
	result.add(res42);	
	result.add(res52);	
	result.add(res62);
	Object[] res13 = {"Course3", "Student1", 4};
	Object[] res23 = {"Course3", "Student2", 6};
	Object[] res33 = {"Course3", "Student3", 6};	
	Object[] res43 = {"Course3", "Student4", 4};
	Object[] res53 = {"Course3", "Student5", 2};
	Object[] res63 = {"Course3", "Student6", 9};
	result.add(res13);	
	result.add(res23);	
	result.add(res33);
	result.add(res43);	
	result.add(res53);	
	result.add(res63);	
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgScoreHomework( Professor professor)
     */
    @Override
    public List<Object[]> getAvgScoreHomework( Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * CourseClass, Student, AvgScore
	 * CourseClass, Student, AvgScore
	 * CourseClass, Student, AvgScore
	 */
	
	// Select only the course of the professor	
	Object[] res11 = {"Course1", "Student1", 24};
	Object[] res21 = {"Course1", "Student2", 22};
	Object[] res31 = {"Course1", "Student3", 21};	
	Object[] res41 = {"Course1", "Student4", 23};
	Object[] res51 = {"Course1", "Student5", 22};
	Object[] res61 = {"Course1", "Student6", 24};
	result.add(res11);	
	result.add(res21);	
	result.add(res31);
	result.add(res41);	
	result.add(res51);	
	result.add(res61);
	Object[] res12 = {"Course2", "Student1", 26};
	Object[] res22 = {"Course2", "Student2", 28};
	Object[] res32 = {"Course2", "Student3", 29};	
	Object[] res42 = {"Course2", "Student4", 20};
	Object[] res52 = {"Course2", "Student5", 21};
	Object[] res62 = {"Course2", "Student6", 22};
	result.add(res12);	
	result.add(res22);	
	result.add(res32);
	result.add(res42);	
	result.add(res52);	
	result.add(res62);
	Object[] res13 = {"Course3", "Student1", 24};
	Object[] res23 = {"Course3", "Student2", 26};
	Object[] res33 = {"Course3", "Student3", 26};	
	Object[] res43 = {"Course3", "Student4", 24};
	Object[] res53 = {"Course3", "Student5", 22};
	Object[] res63 = {"Course3", "Student6", 29};
	result.add(res13);	
	result.add(res23);	
	result.add(res33);
	result.add(res43);	
	result.add(res53);	
	result.add(res63);	
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgAttendanceAllStudent( Professor professor)
     */
    @Override
    public List<Object[]> getAvgAttendanceStudent( Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * CourseClass, AvgAttendance
	 * CourseClass, AvgAttendance
	 * CourseClass, AvgAttendance
	 */
	
	// Select only the course of the professor
	
	// This data are percentual!
	
	Object[] res1 = {"Course1", 24};
	Object[] res2 = {"Course2", 22};
	Object[] res3 = {"Course3", 21};	
	Object[] res4 = {"Course4", 23};
	Object[] res5 = {"Course5", 22};
	Object[] res6 = {"Course6", 24};
	result.add(res1);	
	result.add(res2);	
	result.add(res3);
	result.add(res4);	
	result.add(res5);	
	result.add(res6);
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgHomeworksByStudent( Student student)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getAvgHomeworksByStudent( Student student) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * avgHomeworksByStudent
	 * Course1, AvgScore
	 * Course2, AvgScore
	 * ...
	 * CourseN, AvgScore
	 */
	
	// Dummy data
	//	Object[] res1 = {"Course1", 26.33};
	//	Object[] res2 = {"Course2", 22.33};
	//	Object[] res3 = {"Course3", 28.33};	
	//	Object[] res4 = {"Course4", 26.33};
	//	Object[] res5 = {"Course5", 22.33};
	//	Object[] res6 = {"Course6", 28.33};
	//	result.add(res1);	
	//	result.add(res2);	
	//	result.add(res3);
	//	result.add(res4);	
	//	result.add(res5);	
	//	result.add(res6);
	
	// Query execution
	/*
	 * select C.name, avg(HSS.score)
	 * from CourseClass C, Lecture L, Homework H, HomeworkStudentSolving HSS
	 * where C.lectures = L.id and
	 * 	L.homeworks=H.id and
	 * 	H.homeworkStudentSolvings=HSS.id
	 * group by C.name
	 */
	Session session = DaoHelper.getDbHandler().getSessionFactory().openSession();
	String hql = "select C.name, avg(HSS.score) "
		+ "from CourseClass C join C.lectures L "
		+ "join L.homeworks H join H.homeworkStudentSolvings HSS "
		+ "where HSS.student.username = :username_student "
		+ "group by C.name";
	
	Query query = session.createQuery(hql);
	query.setParameter("username_student", student.getUsername());
	result = query.list();
	session.close();
	
	System.err.println("getAvgHomeworksByStudent(student)");
	System.out.println("Student: "+student.getUsername());
	for(int i=0; i<result.size(); i++){
	    Object[] objects = result.get(i);
	    System.out.println("CourseName: "+objects[0]+", AvgScore: "+objects[1]);
	}
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgTimeDeliveryHomeworksByStudent( Student student)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getAvgTimeDeliveryHomeworksByStudent( Student student) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * avgTimeDeliveryHomeworksByStudent
	 * Course, AvgTime
	 * Course, AvgTime
	 * Course, AvgTime
	 * ...
	 * Course, AvgTime
	 */
	
	Object[] res1 = {"Course1", 2};
	Object[] res2 = {"Course2", 8};
	Object[] res3 = {"Course3", 10};	
	Object[] res4 = {"Course4", 1};
	Object[] res5 = {"Course5", 7};
	Object[] res6 = {"Course6", 4};
	Object[] res7 = {"Course7", 4};
	Object[] res8 = {"Course8", 4};
	Object[] res9 = {"Course9", 4};
	result.add(res1);	
	result.add(res2);	
	result.add(res3);
	result.add(res4);	
	result.add(res5);	
	result.add(res6);	
	result.add(res7);	
	result.add(res8);	
	result.add(res9);
	
	// Query execution
	/*
	 * select C.name, avg(HSS.score)
	 * from CourseClass C, Lecture L, Homework H, HomeworkStudentSolving HSS
	 * where C.lectures = L.id and
	 * 	L.homeworks=H.id and
	 * 	H.homeworkStudentSolvings=HSS.id
	 * group by C.name
	 */
	Session session = DaoHelper.getDbHandler().getSessionFactory().openSession();
	
	String hql = "select C.name, avg("
		+ "DATEDIFF(DAY, HSS.date, L.date)"
		+ ") "
		+ "from CourseClass C join C.lectures L "
		+ "join L.homeworks H join H.homeworkStudentSolvings HSS "
		+ "where HSS.student.username = :username_student "
		+ "group by C.name";
	//	String hql = "select C.name, HSS.date, dayofweek(HSS.date), L.date, DATEDIFF(DAY, HSS.date, L.date) "
	//		+ "from CourseClass C join C.lectures L "
	//		+ "join L.homeworks H join H.homeworkStudentSolvings HSS "
	//		+ "where HSS.student.username = :username_student ";
	
	Query query = session.createQuery(hql);
	query.setParameter("username_student", student.getUsername());
	result = query.list();
	session.close();
	
	System.err.println("getAvgTimeDeliveryHomeworksByStudent(student)");
	System.out.println("Student: "+student.getUsername());
	for(int i=0; i<result.size(); i++){
	    Object[] objects = result.get(i);
	    //System.out.println("CourseName: "+objects[0]+", HSS: "+objects[1]+", DayWeek: "+objects[2]+", L: "+objects[3]+", DIFF: "+objects[4]);
	    System.out.println("CourseName: "+objects[0]+", Avg: "+objects[1]);
	}
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getHomeworkScoreSeriesByStudent( Student student)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getHomeworkScoreSeriesByStudent( Student student) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * Course, Homework, Score
	 * Course, Homework, Score
	 * Course, Homework, Score
	 * ...
	 * Course, Homework, Score
	 */
	
	//	Object[] hw11 = {"Course1", "Homework1",  25};
	//	Object[] hw12 = {"Course1", "Homework2",  26};
	//	Object[] hw13 = {"Course1", "Homework3",  27};
	//	Object[] hw14 = {"Course1", "Homework4",  28};
	//	Object[] hw15 = {"Course1", "Homework5",  29};
	//	result.add(hw11);
	//	result.add(hw12);
	//	result.add(hw13);
	//	result.add(hw14);
	//	result.add(hw15);
	//	Object[] hw21 = {"Course2", "Homework1",  29};
	//	Object[] hw22 = {"Course2", "Homework2",  28};
	//	Object[] hw23 = {"Course2", "Homework3",  27};
	//	Object[] hw24 = {"Course2", "Homework4",  26};
	//	Object[] hw25 = {"Course2", "Homework5",  25};
	//	result.add(hw21);
	//	result.add(hw22);
	//	result.add(hw23);
	//	result.add(hw24);
	//	result.add(hw25);
	//	Object[] hw31 = {"Course3", "Homework1",  29};
	//	Object[] hw32 = {"Course3", "Homework2",  22};
	//	Object[] hw33 = {"Course3", "Homework3",  30};
	//	Object[] hw34 = {"Course3", "Homework4",  26};
	//	Object[] hw35 = {"Course3", "Homework5",  28};
	//	result.add(hw31);
	//	result.add(hw32);
	//	result.add(hw33);
	//	result.add(hw34);
	//	result.add(hw35);
	
	// Query execution
	Session session = DaoHelper.getDbHandler().getSessionFactory().openSession();
	String hql = "select C.name, H.name, HSS.score "
		+ "from CourseClass C join C.lectures L "
		+ "join L.homeworks H join H.homeworkStudentSolvings HSS "
		+ "where HSS.student.username = :username_student "
		+ "group by C.name, H.name, HSS.score "
		+ "order by C.name";
	
	Query query = session.createQuery(hql);
	query.setParameter("username_student", student.getUsername());
	result = query.list();
	session.close();
	
	System.err.println("getHomeworkScoreSeriesByStudent(student)");
	System.out.println("Student: "+student.getUsername());
	for(int i=0; i<result.size(); i++){
	    Object[] objects = result.get(i);
	    for(int j=0; j<objects.length; j++){
		if(j>0){
		    System.out.print(", ");
		}
		System.out.print("Prop "+(j+1)+": "+objects[j]);		
	    }
	    System.out.println();
	}
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getExamScoreSeriesByStudent( Student student)
     */
    @SuppressWarnings("deprecation")
    @Override
    public List<Object[]> getExamScoreSeriesByStudent( Student student) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	/*
	 * Anno, Date, ExamName, Score
	 * Anno, Date, ExamName, Score
	 * Anno, Date, ExamName, Score
	 * Anno, Date, ExamName, Score
	 * ...
	 * Anno, Date, ExamName, Score
	 */
	
	Object[] exam11 = {2012, new Date(2012, 2, 5), "Exam1", 26};
	Object[] exam12 = {2012, new Date(2012, 2, 10), "Exam1", 30};
	Object[] exam13 = {2012, new Date(2012, 2, 15), "Exam1", 28};
	Object[] exam14 = {2012, new Date(2012, 2, 20), "Exam1", 22};
	Object[] exam15 = {2012, new Date(2012, 2, 25), "Exam1", 24};
	result.add(exam11);
	result.add(exam12);
	result.add(exam13);
	result.add(exam14);
	result.add(exam15);
	Object[] exam21 = {2013, new Date(2013, 2, 2), "Exam2", 29};
	Object[] exam22 = {2013, new Date(2013, 2, 7), "Exam2", 27};
	Object[] exam23 = {2013, new Date(2013, 2, 19), "Exam2", 30};
	Object[] exam24 = {2013, new Date(2013, 2, 24), "Exam2", 25};
	Object[] exam25 = {2013, new Date(2013, 2, 26), "Exam2", 30};
	result.add(exam21);
	result.add(exam22);
	result.add(exam23);
	result.add(exam24);
	result.add(exam25);
	Object[] exam31 = {2014, new Date(2014, 3, 1), "Exam3", 26};
	Object[] exam32 = {2014, new Date(2014, 3, 14), "Exam3", 26};
	Object[] exam33 = {2014, new Date(2014, 3, 25), "Exam3", 29};
	Object[] exam34 = {2014, new Date(2014, 3, 28), "Exam3", 30};
	Object[] exam35 = {2014, new Date(2014, 3, 29), "Exam3", 27};
	result.add(exam31);
	result.add(exam32);
	result.add(exam33);
	result.add(exam34);
	result.add(exam35);
	
	// Query execution
	Session session = DaoHelper.getDbHandler().getSessionFactory().openSession();
	String hql = "select year(E.date), E.date, E.name, EP.score "
		+ "from CourseClass C join C.exams E "
		+ "join E.studentExamPartecipations EP "
		+ "where EP.student.username = :username_student "
		+ "group by year(E.date), E.date, E.name, EP.score "
		+ "order by year(E.date), E.date, E.name, EP.score ";
	
	Query query = session.createQuery(hql);
	query.setParameter("username_student", student.getUsername());
	result = query.list();
	session.close();
	
	System.err.println("getExamScoreSeriesByStudent(student)");
	System.out.println("Student: "+student.getUsername());
	for(int i=0; i<result.size(); i++){
	    Object[] objects = result.get(i);
	    for(int j=0; j<objects.length; j++){
		if(j>0){
		    System.out.print(", ");
		}
		System.out.print("Prop "+(j+1)+": "+objects[j]);		
	    }
	    System.out.println();
	}
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgAttendanceByStudent( Student student)
     */
    @Override
    public List<Object[]> getAvgAttendanceByStudent( Student student) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] res1 = {"Course1", 56.33};
	Object[] res2 = {"Course2", 46.33};
	Object[] res3 = {"Course3", 36.33};
	Object[] res4 = {"Course4", 26.33};
	Object[] res5 = {"Course5", 16.33};
	
	result.add(res1);
	result.add(res2);
	result.add(res3);
	result.add(res4);
	result.add(res5);
	
	// Query execution
	Session session = DaoHelper.getDbHandler().getSessionFactory().openSession();
	
	String hql = "select C.name, (count(*)*100.0)/(select count(*) from L where L.courseClass.name=C.name) "
		+ "from RegistrationStudentClass R join R.courseClass C join C.lectures L "
		+ "join L.attendanceStudentLectures A "
		+ "where R.student.username=:username_student and  A.student.username = :username_student "
		+ "group by C.name";
	
	Query query = session.createQuery(hql);
	query.setParameter("username_student", student.getUsername());
	result = query.list();
	session.close();
	
	System.err.println("getAvgAttendanceByStudent(student)");
	System.out.println("Student: "+student.getUsername());
	for(int i=0; i<result.size(); i++){
	    Object[] objects = result.get(i);
	    for(int j=0; j<objects.length; j++){
		if(j>0){
		    System.out.print(", ");
		}
		System.out.print("Prop "+(j+1)+": "+objects[j]);		
	    }
	    System.out.println();
	}
	
	return result;
    }
    
}