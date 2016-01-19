package it.unical.classmanager.utils;

import java.util.Date;

import org.springframework.context.ApplicationContext;

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.NotificationDAO;
import it.unical.classmanager.model.dao.NotificationDAOImpl;
import it.unical.classmanager.model.data.Notification;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.websocket.JettyWebSocketClient;

public class NotificationHelper {
	
	/**
	 * Creazione delle notifiche
	 * @param appContext 
	 */
	public static String createNotification(ApplicationContext appContext, User sendUser, User destinationUser, String message){
		return createNotification(appContext, sendUser, destinationUser, message, "#");
	}
	
	public static String createNotification(ApplicationContext appContext, User sendUser, User destinationUser, String message, String url){
		//NotificationDAO notificationDAO = DaoHelper.getNotificationDAO();
		NotificationDAO notificationDAO = appContext.getBean("notificationDAO", NotificationDAOImpl.class);
		
		Notification notification = new Notification();
		notification.setMessage(message);
		notification.setUrl(url);
		notification.setSource(sendUser);
		notification.setDestination(destinationUser);
		notification.setDate(new Date());
		notificationDAO.create(notification);	
		JettyWebSocketClient.getInstance().sendNotification(notification.getDestination());
		return "websocket";
	}
}
