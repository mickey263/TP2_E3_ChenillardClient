package chenillardClient;

public class ChenillardClient {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
/*		int id   = Integer.valueOf(args[0]);
		int portSrv = Integer.valueOf(args[1]);
		int portClient = Integer.valueOf(args[2]);*/
		
		// Create frame
		ColorFrame frame = new ColorFrame(1, 200, 200);
		Thread.sleep(2000);
		frame.setColor('R');
		Thread.sleep(2000);
		frame.close();
		
		
/*		ServeurUDP serveurUDP = new ServeurUDP();
		serveurUDP.open(PortSrc);
		ClientUDP clientUDP = new ClientUDP();
		clientUDP.open();*/
	}

}
