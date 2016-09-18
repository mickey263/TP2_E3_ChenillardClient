package chenillardClient;

import java.io.IOException;

public class ChenillardClient
{
	
	static ColorFrame frame;
	static Client client;
	

	public static void main(String[] args) throws InterruptedException, IOException
	{
		int id   = Integer.valueOf(args[0]);
		String srvIP = args[1];
		int srvPort = Integer.valueOf(args[2]);
		int clientPort = Integer.valueOf(args[3]);
		int lastClient = Integer.valueOf(args[4]);
		
		// Create frame
		frame = new ColorFrame(id, id*100 + 10, 100);
		client = new Client(srvIP,srvPort,clientPort);
		int newClientPort = clientPort + id;
		
		while(client.isConnected == false)
		{
			client.send("I" + id + "P" + newClientPort);
			if (client.waitingConnection()) {
				System.out.println("Client " + id + " connected");
			}
		}

		System.out.println("Sortie du While");
	}

}
