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

	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public @ResponseBody String getFiles(Model model, @RequestParam("dir") String rootDir) {

		File folder = new File(DIRECTORY);
		List<AbstractFileBean> files = new ArrayList<AbstractFileBean>();

		addTree(folder, files, false);
		FolderBean root = new FolderBean("files", AbstractFileBean.FOLDER_TYPE, folder.getPath(), files, false);

		logger.info("getFiles");

		return new Gson().toJson(root);

	}

	/*
	 * Download a file 
	 */ 
	@RequestMapping(value="/contents/download", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @RequestParam("path") String path) throws IOException {

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

	static void addTree(File folder, List<AbstractFileBean> files, boolean evaluable) {

		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {

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
