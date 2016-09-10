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
	private int Port;
	private String IPHost;
	DatagramSocket socket;
	InetSocketAddress adrDest;
			
	Client(String IPHost, int Port) {
		// Initialize IPHost and Port
		this.Port = Port;
		this.IPHost = IPHost;
	}
	
	public void open() throws IOException
	{
		//
		System.out.println("Demarrage du client ...");
		socket = new DatagramSocket(null);
		adrDest = new InetSocketAddress(IPHost, Port);
	}
	
	public void send(String Msg) throws IOException
	{
		// Create and send message
		byte[] bufE = new String(Msg).getBytes();
		DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, adrDest);
		socket.send(dpE);
		System.out.println("Message sent :" + Msg);
	}
	
	public void waitForInstruction() throws IOException
	{
		// Attente de la reponse 
		byte[] bufR = new byte[2048];
		DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
		socket.receive(dpR);
		String Msg = new String(bufR, dpR.getOffset(), dpR.getLength());
		
		System.out.println("Answer receipt = "+ Msg);
	}
	
	public void close() throws IOException
	{	
		// Fermeture de la socket
		socket.close();
		System.out.println("Arret du client...");
	}
}
