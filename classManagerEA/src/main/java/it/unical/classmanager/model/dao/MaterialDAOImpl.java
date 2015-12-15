package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Material;

public class MaterialDAOImpl {
	
	public void create(Material material){
		DBHandler.getInstance().create(material);
	}

	public void update(Material material){
		DBHandler.getInstance().update(material);
	}

	public void delete(Material material){
		DBHandler.getInstance().delete(material);
	}

	public Material get(Integer id){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		Material material = 
				(Material) session
				.createSQLQuery("SELECT * FROM material WHERE id = " + id)
				.addEntity(Material.class)
				.uniqueResult();
		session.close();
		return material;
	}

	public void deleteAllMaterials(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		session.createQuery("DELETE FROM Material").executeUpdate();
		session.close();		
	}

	public int numberOfMaterials(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		int numMaterial= 
				session.createQuery("FROM Material").list().size();
		session.close();
		return numMaterial;
	}

	@SuppressWarnings("unchecked")
	public List<Material> getAllMaterials(){
		Session session = DBHandler.getInstance().getSessionFactory().openSession();
		List<Material> materials = 
				session.createQuery("FROM Material").list();
		session.close();
		return materials;
	}

}