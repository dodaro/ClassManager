package it.unical.classmanager.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import it.unical.classmanager.model.DBHandler;
import it.unical.classmanager.model.data.Homework;
import it.unical.classmanager.model.data.Material;

public class MaterialDAOImpl implements MaterialDAO
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

	public Material create(Material material)
	{
		return (Material) this.dbHandler.create(material);
	}

	public void update(Material material)
	{
		this.dbHandler.update(material);
	}

	public void delete(Material material)
	{
		this.dbHandler.delete(material);
	}

	public Material get(Integer id)
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		Material material = (Material) session.createSQLQuery("SELECT * FROM material WHERE id = " + id)
				.addEntity(Material.class).uniqueResult();
		session.close();
		return material;
	}

	public void deleteAllMaterials()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		session.createQuery("DELETE FROM Material").executeUpdate();
		session.close();
	}

	public int numberOfMaterials()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		int numMaterial = session.createQuery("FROM Material").list().size();
		session.close();
		return numMaterial;
	}

	@SuppressWarnings("unchecked")
	public List<Material> getAllMaterials()
	{
		Session session = this.dbHandler.getSessionFactory().openSession();
		List<Material> materials = session.createQuery("FROM Material").list();
		session.close();
		return materials;
	}

	@Override
	public List<Material> getAllLectureMaterials(int idLecture) {
		
		Session session = this.dbHandler.getSessionFactory().openSession();

		Query finalQuery = session.createQuery("FROM Material as m WHERE m.lecture.id = :id");
		finalQuery.setParameter("id", idLecture);
		List<Material> materials = finalQuery.list();
		
		return materials;
	}

}