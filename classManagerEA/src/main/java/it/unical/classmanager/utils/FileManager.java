package it.unical.classmanager.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import it.unical.classmanager.model.AbstractFileBean;
import it.unical.classmanager.model.FileBean;
import it.unical.classmanager.model.FolderBean;
import it.unical.classmanager.model.dao.CourseClassDAO;
import it.unical.classmanager.model.dao.CourseClassDAOImpl;
import it.unical.classmanager.model.dao.HomeworkDAO;
import it.unical.classmanager.model.dao.HomeworkDAOImpl;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAO;
import it.unical.classmanager.model.dao.HomeworkStudentSolvingDAOImpl;
import it.unical.classmanager.model.data.CourseClass;
import it.unical.classmanager.model.data.HomeworkStudentSolving;

public class FileManager {

	public final static String RESOURCES_PATH = "files";
	public final static String HOMEWORK_PATH = "homeworks";
	public final static String MATERIALS_PATH = "materials";
	public final static String LECTURES_PATH = "lectures";
	public final static String STUDENTS_PATH = "students";

	@Autowired
	ApplicationContext appContext;

	/**
	 * This method creates a directory in the specified path (without the file separator at the end, without RESOURCES_PATH)
	 * @param path : the path where the directory must be created
	 * @param name : the name of the new directory
	 * @return boolean : false if the operation fails
	 */
	public boolean mkDir(String path, String name){

		final String completePath = RESOURCES_PATH + File.separator + path + File.separator + name;
		return new File(completePath).mkdir();
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

				addTree(listOfFiles[i], flyweight, false);
				FolderBean file = new FolderBean(listOfFiles[i].getName(),AbstractFileBean.FOLDER_TYPE, listOfFiles[i].getPath(), flyweight, evaluable);
				files.add(file);
			}
		}
	}

	/*private boolean isEvaluable(File file) {

		//TODO Devo ricavarlo dalla sessione
		int idCurrentCourse = 0;

		//retrieves the owner course of the new lesson
		CourseClassDAO courseClassDao = appContext.getBean("courseClassDAO",CourseClassDAOImpl.class);
		CourseClass courseClass = courseClassDao.get(idCurrentCourse);

		//TODO prendere solo quelli del corso corrente
		HomeworkStudentSolvingDAO homeworkStudentSolvingDAO = appContext.getBean("homeworkStudentSolvingDAO", HomeworkStudentSolvingDAOImpl.class);
		List<HomeworkStudentSolving> allHomeworks = homeworkStudentSolvingDAO.getAllHomeworkStudentSolvings();

		for (HomeworkStudentSolving homework : allHomeworks) {
			
			if(homework.getHomework().getName().equals(file.getName()))
				return true;
		}

		return false;
	}*/
}
