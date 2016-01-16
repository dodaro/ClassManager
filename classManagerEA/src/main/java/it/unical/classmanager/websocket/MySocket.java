package it.unical.classmanager.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class MySocket 
{	
	public MySocket()
	{
		System.out.println("SocketCreated");
	}
	
	private Map<String, Session> clients = new HashMap<String, Session>(); 
	//private List<Session> sessions = new CopyOnWriteArrayList<Session>();

    @OnWebSocketConnect
    public void onConnect(Session session) 
    {
        System.out.println("Connect");
        try 
        {
            session.getRemote().sendString("Hello Webbrowser");
        } 
        catch (IOException e) 
        {
            System.out.println("IO Exception");
        }
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) throws IOException 
    {
        if(message.matches("^helo:(.+)"))
        {
        	String[] str = message.split(":", 2);
        	clients.put(str[1], session);
        	
        }
        else if(message.matches("^Notify:(.*)"))
        {
        	String[] str = message.split(":", 2);
        	sendMessage(str[1]); 	
        }     
       
        //System.out.println("WS received: " + message + " " + clients.size() + " -- " + sessions.size() + " " + this.toString());
    }
    
    public void sendMessage(String user)
    {
    	try
		{
        	Session userSession = clients.get(user);
        	if(userSession != null)
        		userSession.getRemote().sendString("Notify");
        	else
        		System.out.println("Non posso inviare.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
    }   
    
    /*public void broadcast(String message)
    {
    	for (Session session : sessions)
		{
    		try
			{
				session.getRemote().sendString("Notify");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }*/
	
    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) 
    {
        System.out.println("Close: " + reason);
        clients.remove(session);
    }

    @OnWebSocketError
    public void onError(Throwable t) 
    {
        System.out.println("Error: " + t.getMessage());
    }
}