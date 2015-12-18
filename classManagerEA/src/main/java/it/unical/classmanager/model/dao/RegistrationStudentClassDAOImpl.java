package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.RegistrationStudentClass;

public class RegistrationStudentClassDAOImpl {
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
	
}