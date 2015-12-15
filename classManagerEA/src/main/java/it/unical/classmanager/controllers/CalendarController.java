package it.unical.classmanager.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import it.unical.classmanager.model.FullCalendarEventBean;
import it.unical.classmanager.model.dao.EventDAO;
import it.unical.classmanager.model.dao.EventDAOImpl;
import it.unical.classmanager.model.data.Event;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CalendarController {
	
	@Autowired
	ApplicationContext appContext;
	private static final Logger logger = LoggerFactory.getLogger(CalendarController.class);
	
	/**
	 * Manages the request related to the calendar
	 */
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
	public String getCalendar(Model model) {
		
		model.addAttribute("FullCalendarEventBean", appContext.getBean("event",Event.class));
		logger.info("getCalendar");
		return "calendar";
	
	}
	
	/**
	 * returns all the events of the calendar in json form.
	 * Refer: calendar.jsp
	 * input: String start, String end - the range of the events to retrieve
	 */
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public @ResponseBody String getEvents(Model model, @RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("_") Long preventCaching) {
		
		//is the string containing all the events of the calendar
		//String json = "[{\"id\":\"1\",\"title\": \"Long Event\",\"start\": \"2015-12-07\",\"end\": \"2015-12-10\"}]";
		
		//TODO user session
		EventDAO eventDao = appContext.getBean("eventDao",EventDAOImpl.class);
		List<Event> events = eventDao.getAllEventsOfUser(0);
		
		String json = new Gson().toJson(events);
		model.addAttribute("FullCalendarEventBean", appContext.getBean("event",Event.class));
		
		logger.info("getEvents");
		return json;
	}
	
	/**
	 * This path is invoked every time an event is updated (moved in another date or hour)
	 */
	@RequestMapping(value = "/update_event", method = RequestMethod.POST)
	public @ResponseBody String updateEvent(Model model, @RequestBody FullCalendarEventBean event) {
		
		model.addAttribute("FullCalendarEventBean", appContext.getBean("event",Event.class));
		logger.info("updateEvent");
		return "redirect:calendar";
	}
	
	/**
	 * This path is invoked every time an event is deleted
	 */
	@RequestMapping(value = "/delete_event", method = RequestMethod.POST)
	public String deleteEvent(Model model, FullCalendarEventBean event) {
		
		model.addAttribute("FullCalendarEventBean", appContext.getBean("event",Event.class));
		logger.info("deleteEvent");
		return "redirect:calendar";
	}
	
	/**
	 * This path is invoked every time an new event is created
	 */
	@RequestMapping(value = "/create_event", method = RequestMethod.POST)
	public @ResponseBody String createEvent(Model model, @RequestBody Event event) {
		
		EventDAO eventDao = appContext.getBean("eventDao",EventDAOImpl.class);
		eventDao.create(event);
		model.addAttribute("FullCalendarEventBean", appContext.getBean("event",Event.class));
		
		logger.info("updateEvent");
		return "redirect:calendar";
	}
	
	
}
