package it.unical.classmanager.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Is called when a professor wants to create a new Lecture
 */
@Controller
public class AddNewLectureController {

	private final static String HEADER = "classPage/classPageHeader.jsp";
	private final static String BODY = "classPage/classPageBody.jsp";
	
	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(AddNewLectureController.class);

	
	@RequestMapping(value = "/classes", method = RequestMethod.GET)
	public String getFileBrowserPage(Model model) {

		model.addAttribute("customHeader", AddNewLectureController.HEADER);
		model.addAttribute("customBody", AddNewLectureController.BODY);

		logger.info("getClassPage");
		return "layout";

	}

}
