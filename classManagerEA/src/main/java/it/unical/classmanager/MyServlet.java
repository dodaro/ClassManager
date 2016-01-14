package it.unical.classmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
 
@WebServlet(name = "WebSocket Servlet", urlPatterns = { "/wsexample" })
public class MyServlet extends WebSocketServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("HTTP GET method not implemented.");
    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        //factory.getPolicy().setIdleTimeout(10000); // Si chiude quando va in timeout
        factory.register(MySocket.class);
    }
}