package it.unical.classmanager.websocket;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
 
public class MyAdvancedEchoCreator implements WebSocketCreator 
{  
    private MyWebSocket textEcho;
 
    public MyAdvancedEchoCreator() 
    {
        this.textEcho = new MyWebSocket();
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