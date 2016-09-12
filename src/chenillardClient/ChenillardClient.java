package chenillardClient;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChenillardClient
{
	
	static ColorFrame frame;
	static Client client;
	

	public static void main(String[] args) throws InterruptedException, IOException
	{
		// args
		if(args.length != 5) {
			System.out.println("Wrong args number, use chenillardClient ID ServerIP ServerPort ClientPort LastClient[0|1]");
			System.exit(1);
		}
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
		
		Pattern p = Pattern .compile("P[0-9]{4}");
		String s = "I" + id + "P" + newClientPort;
		Matcher m = p.matcher(s);
		while (m.find())
		      System.out.println(s.substring(m.start()+1, m.end()));

		System.out.println("Sortie du While");
	}

}
