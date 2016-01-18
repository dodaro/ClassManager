package it.unical.classmanager.websocket;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import javax.servlet.annotation.WebServlet;

import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
 
@WebServlet(name = "WebSocket Servlet", urlPatterns = { "/wsexample" }, asyncSupported = true)
public class MyServlet extends WebSocketServlet 
{
	private static final long serialVersionUID = 1L;


	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.getWriter().println("HTTP GET method not implemented.");
    }

    @Override
    public void configure(WebSocketServletFactory factory) 
    {
        factory.getPolicy().setIdleTimeout(1000000);
        factory.setCreator(new MyAdvancedEchoCreator());
    }
}