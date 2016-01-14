package it.unical.classmanager.model.dao;

import java.util.List;

import it.unical.classmanager.model.data.Material;

public interface MaterialDAO {
	public Material create(Material material);

	public void update(Material material);

	public void delete(Material material);

	public Material get(Integer id);

	public void deleteAllMaterials();

	public int numberOfMaterials();

	public List<Material> getAllMaterials();

	public List<Material> getAllLectureMaterials(int idLecture);
}