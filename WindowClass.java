package olwave;


import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class WindowClass extends Canvas {
	
	private int width;
	private int height;
	private String title;
	private Game g ;
	
	public WindowClass(int width, int height, String title, Game g)
	{
//		this.width = width; 
//		this.height = height;
//		this.title = title;
//		this.g = g;
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.add(g);
		frame.setVisible(true);
		
		
		g.start();
		
		
		
	}

}
