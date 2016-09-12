package chenillardClient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Client basique UDP
 * 
 */
public class Client
{
	private int SrvPort;
	private int ClientPort;
	private String ServerIP;
	public boolean isConnected = false;
	DatagramSocket socket;
	InetSocketAddress adrDest;
			
	Client(String ServerIP, int SrvPort, int ClientPort) throws IOException {
		// Initialize ServerIP, SrvPort and ClientPort
		this.SrvPort = SrvPort;
		this.ServerIP = ServerIP;
		this.ClientPort = ClientPort;
		open();
	}
	
	public void open() throws IOException
	{
		//
		System.out.println("Demarrage du client ...");
		socket = new DatagramSocket(null);
		System.out.println(ServerIP);
		adrDest = new InetSocketAddress(ServerIP, SrvPort);
		socket.bind(new InetSocketAddress(ClientPort));
	}
	
	public void send(String Msg) throws IOException
	{
		// Create and send message
		byte[] bufE = new String(Msg).getBytes();
		DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, adrDest);
		socket.send(dpE);
		System.out.println("Message sent :" + Msg);
	}
	
	public boolean waitingConnection() throws IOException
	{
		// Attente de la reponse 
		byte[] bufR = new byte[2048];
		DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
		socket.receive(dpR);
		String Msg = new String(bufR, dpR.getOffset(), dpR.getLength());

		if ("ACK".equals(Msg.replaceAll("[\r\n]+", "")))
		{
			isConnected = true;
			System.out.println("Answer receive OK = "+ Msg);
			return true;
		}
		
		System.out.println("Answer receive NOK = "+ Msg);
		return false;
	}
	
	public void close() throws IOException
	{	
		// Fermeture de la socket
		socket.close();
		System.out.println("Arret du client...");
	}
}
