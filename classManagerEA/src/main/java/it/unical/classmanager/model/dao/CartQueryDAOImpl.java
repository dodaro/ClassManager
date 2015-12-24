package it.unical.classmanager.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<Object[]> getCourseByProfessor( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getForYearLectureByWeekDaySingleProfessor( Professor professor)
     */
    @Override
    public List<Object[]> getForYearLectureByWeekDaySingleProfessor( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getForYearAvgLectureByWeekDaySingleProfessor( Professor professor)
     */
    @Override
    public List<Object[]> getForYearAvgLectureByWeekDaySingleProfessor( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgLectureByWeekDaySingleProfessor( Professor professor)
     */
    @Override
    public List<Object[]> getAvgLectureByWeekDaySingleProfessor( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getForYearLectureByWeekDayAllProfessor( List<Professor> professors)
     */
    @Override
    public List<Object[]> getForYearLectureByWeekDayAllProfessor( List<Professor> professors) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getForYearAvgLectureByWeekDayAllProfessor( List<Professor> professors)
     */
    @Override
    public List<Object[]> getForYearAvgLectureByWeekDayAllProfessor( List<Professor> professors) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgLectureByWeekDayAllProfessor( List<Professor> professors)
     */
    @Override
    public List<Object[]> getAvgLectureByWeekDayAllProfessor( List<Professor> professors) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgTimeDeliveryHomework( Professor professor)
     */
    @Override
    public List<Object[]> getAvgTimeDeliveryHomework( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgScoreHomework( Professor professor)
     */
    @Override
    public List<Object[]> getAvgScoreHomework( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgAttendanceAllStudent( Professor professor)
     */
    @Override
    public List<Object[]> getAvgAttendanceAllStudent( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgAttendanceSingleStudent( Professor professor)
     */
    @Override
    public List<Object[]> getAvgAttendanceSingleStudent( Professor professor) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgHomeworksByStudent( Student student)
     */
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
	
	Object[] res1 = {"Course1", 26.33};
	Object[] res2 = {"Course2", 22.33};
	Object[] res3 = {"Course3", 28.33};	
	Object[] res4 = {"Course4", 26.33};
	Object[] res5 = {"Course5", 22.33};
	Object[] res6 = {"Course6", 28.33};
	result.add(res1);	
	result.add(res2);	
	result.add(res3);
	result.add(res4);	
	result.add(res5);	
	result.add(res6);
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgTimeDeliveryHomeworksByStudent( Student student)
     */
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
	
	return result;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getHomeworkScoreSeriesByStudent( Student student)
     */
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
	
	Object[] hw11 = {"Course1", "Homework1",  25};
	Object[] hw12 = {"Course1", "Homework2",  26};
	Object[] hw13 = {"Course1", "Homework3",  27};
	Object[] hw14 = {"Course1", "Homework4",  28};
	Object[] hw15 = {"Course1", "Homework5",  29};
	result.add(hw11);
	result.add(hw12);
	result.add(hw13);
	result.add(hw14);
	result.add(hw15);
	Object[] hw21 = {"Course2", "Homework1",  29};
	Object[] hw22 = {"Course2", "Homework2",  28};
	Object[] hw23 = {"Course2", "Homework3",  27};
	Object[] hw24 = {"Course2", "Homework4",  26};
	Object[] hw25 = {"Course2", "Homework5",  25};
	result.add(hw21);
	result.add(hw22);
	result.add(hw23);
	result.add(hw24);
	result.add(hw25);
	Object[] hw31 = {"Course3", "Homework1",  29};
	Object[] hw32 = {"Course3", "Homework2",  22};
	Object[] hw33 = {"Course3", "Homework3",  30};
	Object[] hw34 = {"Course3", "Homework4",  26};
	Object[] hw35 = {"Course3", "Homework5",  28};
	result.add(hw31);
	result.add(hw32);
	result.add(hw33);
	result.add(hw34);
	result.add(hw35);
	
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
	
	return result;
    }
    
}