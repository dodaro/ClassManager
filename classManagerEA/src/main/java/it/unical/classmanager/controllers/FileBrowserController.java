package it.unical.classmanager.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import it.unical.classmanager.model.AbstractFileBean;
import it.unical.classmanager.model.FileBean;
import it.unical.classmanager.model.FolderBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileBrowserController {
	
	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(FileBrowserController.class);
	
	private static final String DIRECTORY = "files";
	
	/**
	 * Manages the request related to the file browser
	 */
	@RequestMapping(value = "/fileBrowser", method = RequestMethod.GET)
	public String getFileBrowserPage(Model model) {

		//List<String> files = new ArrayList<String>();
		
		
		logger.info("getFiles");
		return "fileBrowser";
	
	}
	
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public @ResponseBody String getFiles(Model model, @RequestParam("dir") String rootDir) {

		File folder = new File(DIRECTORY);
		List<AbstractFileBean> files = new ArrayList<AbstractFileBean>();
		
		/*File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	 
		    	FileBean file = FileBean.toFileBean(listOfFiles[i]);
		    	files.add(file);
		    	
		      } else if (listOfFiles[i].isDirectory()) {
		        
		    	  List<AbstractFileBean> flyweight = new ArrayList<AbstractFileBean>();
		    	  for (File file : listOfFiles[i].listFiles()) {
					flyweight.add(FileBean.toFileBean(file));
		    	  }
		    	  
		    	  FolderBean file = new FolderBean(listOfFiles[i].getName(),AbstractFileBean.FOLDER_TYPE, listOfFiles[i].getPath(), flyweight);
		    	  files.add(file);
		      }
		    }
		*/
		addTree(folder, files);
		FolderBean root = new FolderBean("files", AbstractFileBean.FOLDER_TYPE, folder.getPath(), files);
		
		logger.info("getFiles");
		
		return new Gson().toJson(root);
	
	}
	
	static void addTree(File folder, List<AbstractFileBean> files) {
		
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	 
		    	FileBean file = FileBean.toFileBean(listOfFiles[i]);
		    	files.add(file);
		    	
		      } else if (listOfFiles[i].isDirectory()) {
		        
		    	  List<AbstractFileBean> flyweight = new ArrayList<AbstractFileBean>();
		    	  //for (File file : listOfFiles[i].listFiles()) {
					//flyweight.add(FileBean.toFileBean(file));
		    	  //}
		    	  
		    	  addTree(listOfFiles[i], flyweight);
		    	  FolderBean file = new FolderBean(listOfFiles[i].getName(),AbstractFileBean.FOLDER_TYPE, listOfFiles[i].getPath(), flyweight);
		    	  files.add(file);
		      }
		    }
	}
	
}
