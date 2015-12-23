package it.unical.classmanager.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import it.unical.classmanager.model.AbstractFileBean;
import it.unical.classmanager.model.FileBean;
import it.unical.classmanager.model.FolderBean;

public class FileManager {

	public final static String RESOURCES_PATH = "files";
	public final static String HOMEWORK_PATH = "homework";
	public final static String MATERIALS_PATH = "materials";
	
	/**
	 * This method creates a directory in the specified path
	 * @param path : the path where the directory must be created
	 * @param name : the name of the new directory
	 * @return boolean : false if the operation fails
	 */
	public boolean mkDir(String path, String name){
		
		return new File(RESOURCES_PATH + File.separator + path + File.separator + name).mkdir();
	}
	
	/**
	 * Creates a new file in the specified path
	 * @param path is the path where to create the new file
	 * @param name is the name of the new file
	 * @return false if the operation fails
	 */
	public boolean mkFile(String path, String name){
	
		String path_ = path + File.separator + name;
		path_ = path_.replaceAll("/", File.separator);
		File f = new File(path); 
		
		boolean success = false;
		try {
			
			success = f.createNewFile();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return success;
	}
	
	/**
	 * Creates a new file in the specified path starting from a multipart
	 * @param path is the path where to create the new file
	 * @param name is the name of the new file
	 * @return false if the operation fails
	 */
	public boolean mkMultipartFile(MultipartFile file, String path, String name){
	
		String path_ = path + File.separator + name;
		path_ = path_.replaceAll("/", File.separator);
		path_ = path_.replaceAll(" ", "\\ ");
		
		File f = new File(path_); 
		
		boolean success = false;
		try {
		
			file.transferTo(f);
			success = true;
		
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		}
		
		return success;
	}
	
	/**
	 * This method create recursively a tree of files
	 * 
	 * @param folder : is the root folder
	 * @param files	: is the list of the files contained in {@link @param folder}
	 * @param evaluable : indicates if the file is evaluable or not and if it has a score
	 */
	public void addTree(File folder, List<AbstractFileBean> files, boolean evaluable) {

		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && !listOfFiles[i].isHidden()) {

				FileBean file = FileBean.toFileBean(listOfFiles[i]);
				files.add(file);

			} else if (listOfFiles[i].isDirectory()) {

				List<AbstractFileBean> flyweight = new ArrayList<AbstractFileBean>();

				addTree(listOfFiles[i], flyweight, true);
				FolderBean file = new FolderBean(listOfFiles[i].getName(),AbstractFileBean.FOLDER_TYPE, listOfFiles[i].getPath(), flyweight, evaluable);
				files.add(file);
			}
		}
	}
}
