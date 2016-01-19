package it.unical.classmanager.utils;

import java.util.Date;

import it.unical.classmanager.model.dao.DaoHelper;
import it.unical.classmanager.model.dao.NotificationDAO;
import it.unical.classmanager.model.data.Notification;
import it.unical.classmanager.model.data.User;
import it.unical.classmanager.websocket.JettyWebSocketClient;

public class NotificationHelper {
	
	/**
	 * Notification's creations
	 */
	public static String createNotification(User sendUser, User destinationUser, String message){
		return createNotification(sendUser, destinationUser, message, "#");
	}
	
	public static String createNotification(User sendUser, User destinationUser, String message, String url){
		NotificationDAO notificationDAO = DaoHelper.getNotificationDAO();
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