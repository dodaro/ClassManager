package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.RegistrationStudentClass;

public class RegistrationStudentClassDAOImpl {
	
	public void create(RegistrationStudentClass registrationStudentClass){
		DBHandler.getInstance().create(registrationStudentClass);
	}

	public void update(RegistrationStudentClass registrationStudentClass){
		DBHandler.getInstance().update(registrationStudentClass);
	}

	public void delete(RegistrationStudentClass registrationStudentClass){
		DBHandler.getInstance().delete(registrationStudentClass);
	}

	public RegistrationStudentClass get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		RegistrationStudentClass registrationStudentClass = 
				(RegistrationStudentClass) session
				.createSQLQuery("SELECT * FROM registrationStudentClass WHERE id = " + id)
				.addEntity(RegistrationStudentClass.class)
				.uniqueResult();
		session.close();
		return registrationStudentClass;
	}

	public void deleteAllRegistrationStudentClasses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM RegistrationStudentClass").executeUpdate();
		session.close();		
	}

	public int numberOfRegistrationStudentClasses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numRegistrationStudentClass = 
				session.createQuery("FROM RegistrationStudentClass").list().size();
		session.close();
		return numRegistrationStudentClass;
	}

	@SuppressWarnings("unchecked")
	public List<RegistrationStudentClass> getAllRegistrationStudentClasses(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<RegistrationStudentClass> registrationStudentClasses = 
				session.createQuery("FROM RegistrationStudentClass").list();
		session.close();
		return registrationStudentClasses;
	}
	
}