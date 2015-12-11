package it.unical.classmanager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		model.addAttribute("FullCalendarEventBean", new FullCalendarEventBean());
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
		String json = "[{\"id\":\"1\",\"title\": \"Long Event\",\"start\": \"2015-12-07\",\"end\": \"2015-12-10\"}]";
		
		model.addAttribute("FullCalendarEventBean", new FullCalendarEventBean());
		logger.info("getEvents");
		return json;
	}
	
	/*
	 * This path is invoked every time an event is updated (moved in another date or hour)
	 */
	@RequestMapping(value = "/update_event", method = RequestMethod.POST)
	public @ResponseBody String updateEvent(Model model, @RequestBody FullCalendarEventBean event) {
		
		model.addAttribute("FullCalendarEventBean", new FullCalendarEventBean());
		logger.info("updateEvent");
		return "calendar";
	}
	
	/*
	 * This path is invoked every time an event is deleted
	 */
	@RequestMapping(value = "/delete_event", method = RequestMethod.POST)
	public String deleteEvent(Model model, FullCalendarEventBean event) {
		
		model.addAttribute("FullCalendarEventBean", new FullCalendarEventBean());
		logger.info("deleteEvent");
		return "redirect:calendar";
	}
	
	/*
	 * This path is invoked every time an new event is created
	 */
	@RequestMapping(value = "/create_event", method = RequestMethod.POST)
	public @ResponseBody String createEvent(Model model, @RequestBody FullCalendarEventBean event) {
		
		model.addAttribute("FullCalendarEventBean", new FullCalendarEventBean());
		logger.info("updateEvent");
		return "calendar";
	}
	
	
}
