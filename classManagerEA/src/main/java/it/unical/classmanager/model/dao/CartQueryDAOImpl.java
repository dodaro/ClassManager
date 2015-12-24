package it.unical.classmanager.model.dao;

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
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgTimeDeliveryHomeworksByStudent( Student student)
     */
    @Override
    public List<Object[]> getAvgTimeDeliveryHomeworksByStudent( Student student) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getHomeworkScoreSeriesByStudent( Student student)
     */
    @Override
    public List<Object[]> getHomeworkScoreSeriesByStudent( Student student) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getExamScoreSeriesByStudent( Student student)
     */
    @Override
    public List<Object[]> getExamScoreSeriesByStudent( Student student) {
	// TODO Auto-generated method stub
	return null;
    }
    
    /* (non-Javadoc)
     * @see it.unical.classmanager.model.dao.CartQueryDAO#getAvgAttendanceByStudent( Student student)
     */
    @Override
    public List<Object[]> getAvgAttendanceByStudent( Student student) {
	// TODO Auto-generated method stub
	return null;
    }
    
    //	public Communications get(Integer id)
    //	{
    //		Session session = this.dbHandler.getSessionFactory().openSession();
    //		Communications communications = (Communications) session
    //				.createSQLQuery("SELECT * FROM communications WHERE id = " + id).addEntity(Communications.class)
    //				.uniqueResult();
    //		session.close();
    //		return communications;
    //	}
    //
    //	public void deleteAllCommunications()
    //	{
    //		Session session = this.dbHandler.getSessionFactory().openSession();
    //		session.createQuery("DELETE FROM Communications").executeUpdate();
    //		session.close();
    //	}
    //
    //	public int numberOfCommunications()
    //	{
    //		Session session = this.dbHandler.getSessionFactory().openSession();
    //		int numCommunications = session.createQuery("FROM Communications").list().size();
    //		session.close();
    //		return numCommunications;
    //	}
    //
    //	@SuppressWarnings("unchecked")
    //	public List<Communications> getAllCommunications()
    //	{
    //		Session session = this.dbHandler.getSessionFactory().openSession();
    //		List<Communications> communications = session.createQuery("FROM Communications").list();
    //		session.close();
    //		return communications;
    //	}
    
}