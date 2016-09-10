package chenillardClient;

import java.awt.Color;
import javax.swing.JFrame;

public class ColorFrame
{
	// initialise frame object
	private JFrame frame;
	
	// constructor
	// args : id : frame id
	//		: x  : x frame position
	//      : y  : y frame position
	ColorFrame(int id, int x, int y)
	{
		// create  frame name chenillard$Id
		frame = new JFrame("Chenillard" + id);
		//compr
		
		// set frame size
		frame.setSize(300,300);
		
		// set frame location
		frame.setLocation(x, y);
		
		// set frame to green color
		frame.getContentPane().setBackground(Color.GREEN);
		
		// sow frame
		frame.setVisible(true);	
	}
	
	// get x frame position
	public void setColor(char FrameColor) {
		switch (FrameColor)
		{
			case 'G':
				frame.getContentPane().setBackground(Color.GREEN);
				break;
			case 'R':
				frame.getContentPane().setBackground(Color.RED);
				break;
			default :
				System.out.println("Color not defined");				
				break;
		}
	}
	
	// close frame
	public void close() {frame.dispose();}
}
