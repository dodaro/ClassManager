package it.unical.classmanager.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.classmanager.model.FullCalendarEventBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CalendarController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	/**
	 * Manages the request related to the calendar
	 */
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String getCalendar(Model model) {
		
		logger.info("getCalendar");
		return "calendar";
	
	}
	
	/*
	 * returns all the events of the calendar in json form.
	 * Refer: calendar.jsp
	 * input: String start, String end - the range of the events to retrieve
	 */
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody String getEvents(Model model, @RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("_") Long preventCaching) {
		
		//is the string containing all the events of the calendar
		String json = "[{\"title\": \"All Day Event\", \"start\": \"2015-12-01\", \"editable\": \"true\"},{\"title\": \"Long Event\",\"start\": \"2015-12-07\",\"end\": \"2015-12-10\"}]";
		
		//TODO add attributes to model
		
		logger.info("getEvents");
		return json;
	}
	
	@RequestMapping(value = "/update_event", method = RequestMethod.POST)
	public String updateEvent(HttpServletRequest request,@RequestBody FullCalendarEventBean event) {
		
		logger.info("updateEvent");
		return "calendar";
	}
	
	
	
	
	
}
