package it.unical.classmanager.websocket;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
 
public class MyAdvancedEchoCreator implements WebSocketCreator 
{  
    private MySocket textEcho;
 
    public MyAdvancedEchoCreator() 
    {
        this.textEcho = new MySocket();
    }
 
    @SuppressWarnings("unused")
	@Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) 
    {
        for (String subprotocol : req.getSubProtocols()) 
        {            
        	return textEcho;
        }
        return textEcho;
    }
}