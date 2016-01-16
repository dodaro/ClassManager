package it.unical.classmanager.controllers;

import java.util.Locale;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import it.unical.classmanager.model.NotificationJSON;
import it.unical.classmanager.model.dao.NotificationDAO;
import it.unical.classmanager.model.dao.NotificationDAOImpl;
import it.unical.classmanager.model.dao.UserDAO;
import it.unical.classmanager.model.dao.UserDAOImpl;
import it.unical.classmanager.model.data.Notification;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.websocket.JettyWebSocketClient;

@Controller
public class WSC
{
	private static final Logger logger = LoggerFactory.getLogger(AttendanceLessonController.class);

	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(value = "/ws", method = RequestMethod.GET)
	public String init(HttpServletRequest request, Model model, Locale locale)
	{	
		logger.info((String) request.getSession().getAttribute("loggedIn"));
		model.addAttribute("websocketUser", request.getSession().getAttribute("loggedIn"));		
		return "websocket";
	}
	
	@RequestMapping(value = "/wsSend", method = RequestMethod.GET)
	public String send(HttpServletRequest request, Model model, Locale locale)
	{
		NotificationDAO notificationDAO = context.getBean("notificationDAO", NotificationDAOImpl.class);
		Notification n = new Notification();
		n.setMessage("Message notification.");
		n.setUrl("http://localhost/ws");
		UserDAO userDAO = context.getBean("userDao", UserDAOImpl.class);
		User currentUser = userDAO.get((String)request.getSession().getAttribute("loggedIn"));
		n.setSource(currentUser);
		n.setDestination(currentUser);
		n.setDate(new Date());
		notificationDAO.create(n);	
		System.out.println(n.toString());
		
		JettyWebSocketClient.getInstance().sendMessage("Notification!");
		return "websocket";
	}
	
	@RequestMapping(value = "/getNewNotifications", method = RequestMethod.GET)
	public @ResponseBody String getNotifications(HttpServletRequest request, Model model, Locale locale) 
	{	 
		UserDAO userDAO = context.getBean("userDao", UserDAOImpl.class);
		User currentUser = userDAO.get("admin");//(String)request.getSession().getAttribute("loggedIn"));
		NotificationDAO notificationDAO = context.getBean("notificationDAO", NotificationDAOImpl.class);
		List<NotificationJSON> notifications = notificationDAO.getNotifications(currentUser);
		//notificationDAO.setNotificationsRead(currentUser);
		
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(notifications);
	    return json;
	}
}
