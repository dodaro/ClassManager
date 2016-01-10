package it.unical.classmanager.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.invitations.InvitationBean;
import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.Professor;
import it.unical.classmanager.model.data.RegistrationStudentClass;
import it.unical.classmanager.model.data.Student;

public class RegistrationStudentClassDAOImpl implements RegistrationStudentClassDAO {
    private DBHandler dbHandler;
    
    public void setDbHandler(DBHandler dbHandler)
    {
	this.dbHandler = dbHandler;
    }
    
    public DBHandler getDbHandler()
    {
	return dbHandler;
    }
    
    public void create(RegistrationStudentClass registrationStudentClass){
	this.dbHandler.create(registrationStudentClass);
    }
    
    public void update(RegistrationStudentClass registrationStudentClass){
	this.dbHandler.update(registrationStudentClass);
    }
    
    public void delete(RegistrationStudentClass registrationStudentClass){
	this.dbHandler.delete(registrationStudentClass);
    }
    
    public RegistrationStudentClass get(Integer id){
	Session session = this.dbHandler.getSessionFactory().openSession();
	RegistrationStudentClass registrationStudentClass = 
		(RegistrationStudentClass) session
		.createSQLQuery("SELECT * FROM registrationStudentClass WHERE id = " + id)
		.addEntity(RegistrationStudentClass.class)
		.uniqueResult();
	session.close();
	return registrationStudentClass;
    }
    
    public void deleteAllRegistrationStudentClasses(){
	Session session = this.dbHandler.getSessionFactory().openSession();
	session.createQuery("DELETE FROM RegistrationStudentClass").executeUpdate();
	session.close();		
    }
    
    public int numberOfRegistrationStudentClasses(){
	Session session = this.dbHandler.getSessionFactory().openSession();
	int numRegistrationStudentClass = 
		session.createQuery("FROM RegistrationStudentClass").list().size();
	session.close();
	return numRegistrationStudentClass;
    }
    
    @SuppressWarnings("unchecked")
    public List<RegistrationStudentClass> getAllRegistrationStudentClasses(){
	Session session = this.dbHandler.getSessionFactory().openSession();
	List<RegistrationStudentClass> registrationStudentClasses = 
		session.createQuery("FROM RegistrationStudentClass").list();
	session.close();
	return registrationStudentClasses;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getStudentsRegisteredToACourse(CourseClass course)
    {
	Session session = this.dbHandler.getSessionFactory().openSession();		
	List<Student> students = session.createQuery("SELECT student FROM RegistrationStudentClass WHERE courseClass = :course ").setParameter("course", course).list();
	session.close();
	return students;
    }
    
    @Override
    public List<Object[]> getSelectableCourse(Student student){
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Corso1", "Professore1"};
	result.add(el1);
	Object[] el2 = {"Corso2", "Professore2"};
	result.add(el2);
	
	return result;
    }
    
    @Override
    public List<Object[]> getSelectableCourse(Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Corso1"};
	result.add(el1);
	Object[] el2 = {"Corso2"};
	result.add(el2);
	
	return result;
    }
    
    @Override
    public List<Object[]> getCancellableCourse(Student student){
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Corso1", "Professore1"};
	result.add(el1);
	Object[] el2 = {"Corso2", "Professore2"};
	result.add(el2);
	
	return result;	
    }
    
    @Override
    public List<Object[]> getSelectableStudent(CourseClass courseClass){
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Studente1"};
	result.add(el1);
	Object[] el2 = {"Studente2"};
	result.add(el2);
	
	return result;	
    }
    
    @Override
    public List<Object[]> getCancellableStudent(CourseClass courseClass){
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Studente1"};
	result.add(el1);
	Object[] el2 = {"Studente2"};
	result.add(el2);
	
	return result;	
    }
    
    @Override
    public List<Object[]> getAcceptableCourse(Student student) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Corso1", "Professore1"};
	result.add(el1);
	Object[] el2 = {"Corso2", "Professore2"};
	result.add(el2);
	
	return result;
    }
    
    @Override
    public List<Object[]> getAcceptableStudent(Professor professor) {
	List<Object[]> result = new ArrayList<Object[]>();
	
	Object[] el1 = {"Studente1", "Corso1"};
	result.add(el1);
	Object[] el2 = {"Studente1", "Corso2"};
	result.add(el2);
	Object[] el3 = {"Studente2", "Corso1"};
	result.add(el3);
	
	return result;	
    }
    
    @Override
    public int getNewInvitationsOfStudent(Student student) {	
	return 10;	
    }
    
    @Override
    public int getNewInvitationsOfProfessor(Professor professor) {	
	return 20;	
    }
    
}