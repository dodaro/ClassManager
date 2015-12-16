package it.unical.classmanager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String form() {
		return "upload";
	}
	
	@RequestMapping(value="/file", method=RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile file) {
		// Do custom steps here
		// i.e. Save the file to a temporary location or database
		logger.info("saving file");
		return "{\"status\":\"success\"}";
	}
}