package it.unical.classmanager.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ser.std.FileSerializer;
import com.google.gson.Gson;

import it.unical.classmanager.model.AbstractFileBean;
import it.unical.classmanager.model.FileBean;
import it.unical.classmanager.model.FolderBean;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.utils.FileManager;

/**
 * Is called when is necessary retrieve files starting from a root
 */
@Controller
public class FileBrowserController {

	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(FileBrowserController.class);
	
	public static final String LECTURES_ROOT_TYPE = "lectures";
	public static final String STUDENTS_HOMEWORKS_ROOT_TYPE = "students";

	/**
	 * This method is called to construct a three of files, starting from a root
	 * 
	 * @param rootDir : starting from this folder a tree of files is build and returned as a JSON
	 * @return JSON
	 */
	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public @ResponseBody String getFiles(Model model, @RequestParam("type") String type) {

		User user = new User();
		if(type.equals(LECTURES_ROOT_TYPE))
			return getLectures(user);
		else if (type.equals(STUDENTS_HOMEWORKS_ROOT_TYPE))
			return getStudentsHomeworks(user);
				

		return "{}";
	}
	
	public String getLectures(User professor){
		
		boolean isProfessor = true;

		List<AbstractFileBean> files = new ArrayList<AbstractFileBean>();
		FolderBean root = new FolderBean("files", AbstractFileBean.FOLDER_TYPE, FileManager.RESOURCES_PATH, files, false);

		if(isProfessor){

			//TODO Replace with DAO
			List<String> courses = new ArrayList<String>();
			String coursePath1 = "enterpriseApplication";
			courses.add(FileManager.RESOURCES_PATH + File.separator + coursePath1);
			
			createTreeFromCourses(courses, files);
		}

		logger.info("getFiles");

		return new Gson().toJson(root);
	}
	
	public String getStudentsHomeworks(User professor){
		
		boolean isProfessor = true;

		List<AbstractFileBean> files = new ArrayList<AbstractFileBean>();
		FolderBean root = new FolderBean("files", AbstractFileBean.FOLDER_TYPE, FileManager.RESOURCES_PATH, files, false);

		if(isProfessor){

			//TODO Replace with DAO
			List<String> students = new ArrayList<String>();
			String studentPath = "student1";
			students.add(FileManager.RESOURCES_PATH + File.separator + FileManager.STUDENTS_PATH + File.separator + studentPath);
			
			createTreeFromCourses(students, files);
		}

		logger.info("getFiles");

		return new Gson().toJson(root);
	}

	/**
	 * This method allows the user to download the file contained in the parameter "path"
	 * @param path : is the parameter of the GET request, that is the path of the file to dowload
	 */ 
	@RequestMapping(value="/contents/download", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @RequestParam("path") String path) throws IOException {

		//TODO Security check
		File file = null;

		String workingDir = System.getProperty("user.dir");
		Resource resource = appContext.getResource("file:" + workingDir + "/" + path);
		file = resource.getFile();

		if(!file.exists()){
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}

		String mimeType= URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType==null){
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}

		System.out.println("mimetype : "+mimeType);

		response.setContentType(mimeType);

		/* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));


		/* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
		//response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));

		response.setContentLength((int)file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

		//Copy bytes from source to destination(outputstream in this example), closes both streams.
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}


	//TODO database connection. Delete returns false
	/**
	 * This method is called when a particular file needs to be deleted
	 * @params path : the complete path of the file to delete
	 */
	@RequestMapping(value = "/contents/delete", method = RequestMethod.GET)
	public @ResponseBody String deleteFile(Model model, @RequestParam("path") String path) {

		boolean delete = false;
		try{

			String workingDir = System.getProperty("user.dir");
			File file = new File(workingDir + "/" + path);
			delete = file.delete();

		}catch(Exception e){

			e.printStackTrace();

		}

		logger.info("deleteFile");

		return Boolean.toString(delete);

	}

	/**
	 * Should be used after a query about the courses of a specific Professor. 
	 * For each root directory "course" in courses the sub tree is added to the folder list
	 * @param courses
	 * @param folder
	 * @param files
	 */
	private void createTreeFromCourses(List<String> courses, List<AbstractFileBean> files){

		FileManager fm = new FileManager();
		for (String course : courses) {	

			File folder = new File(course);
			fm.addTree(folder, files, false);
		}
	}

}
