package it.unical.classmanager.websocket;

import java.net.URI;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class JettyWebSocketClient
{
	private static JettyWebSocketClient _instance = null;

	public static JettyWebSocketClient getInstance()
	{
		if (_instance == null)
			_instance = new JettyWebSocketClient();
		return _instance;
	}

	private JettyWebSocketClient()
	{}

	public void sendMessage(String message)
	{
		String dest = "ws://localhost:8080/wsexample";
		WebSocketClient client = new WebSocketClient();
		try
		{
			ClientWebSocket socket = new ClientWebSocket();
			client.start();
			URI echoUri = new URI(dest);
			ClientUpgradeRequest request1 = new ClientUpgradeRequest();
			client.connect(socket, echoUri, request1);
			socket.getLatch().await();
			socket.sendMessage(message);
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
		finally
		{
			try
			{
				client.stop();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}