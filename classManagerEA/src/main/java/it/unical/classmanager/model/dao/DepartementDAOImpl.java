package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Departement;

public class DepartementDAOImpl {
	
	public void create(Departement departement){
		DBHandler.getInstance().create(departement);
	}

	public void update(Departement departement){
		DBHandler.getInstance().update(departement);
	}

	public void delete(Departement departement){
		DBHandler.getInstance().delete(departement);
	}

	public Departement get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Departement departement = 
				(Departement) session
				.createSQLQuery("SELECT * FROM departement WHERE id = " + id)
				.addEntity(Departement.class)
				.uniqueResult();
		session.close();
		return departement;
	}

	public void deleteAllDepartements(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Departement").executeUpdate();
		session.close();		
	}

	public int numberOfDepartements(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numDepartement= 
				session.createQuery("FROM Departement").list().size();
		session.close();
		return numDepartement;
	}

	@SuppressWarnings("unchecked")
	public List<Departement> getAllDepartements(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Departement> departement = 
				session.createQuery("FROM Departement").list();
		session.close();
		return departement;
	}
	
}
