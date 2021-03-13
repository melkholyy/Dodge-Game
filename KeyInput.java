package olwave;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) 
	{
		int event =  e.getKeyCode();
		System.out.println(event);
		
		for(int i=0; i< handler.gameObject.size() ; i++)
		{
			GameObject object = handler.gameObject.get(i);
			
			if(object.getType() == Type.Player)
			{
				if(event == KeyEvent.VK_UP)
				{
					object.setDY(-10);
						
				}
				else if(event == KeyEvent.VK_DOWN)
				{
					object.setDY(10);
				}
				else if(event == KeyEvent.VK_LEFT)
				{
					object.setDX(-10);
				}
				else if(event == KeyEvent.VK_RIGHT)
				{
					object.setDX(10);
				}
			}
			
			
			 if(event == KeyEvent.VK_ESCAPE) System.exit(1);
	}
		
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int event = e.getKeyCode();
		
		for(int i=0; i< handler.gameObject.size() ; i++)
		{
			GameObject object = handler.gameObject.get(i);
			
			if(object.getType() == Type.Player)
			{
				if(event == KeyEvent.VK_UP)
				{
					object.setDY(0);
				}
				else if(event == KeyEvent.VK_DOWN)
				{
					object.setDY(0);
				}
				else if(event == KeyEvent.VK_LEFT)
				{
					object.setDX(0);
				}
				else if(event == KeyEvent.VK_RIGHT)
				{
					object.setDX(0);
				}
			}
		
			 
			 
	}
		if(event == KeyEvent.VK_ESCAPE) System.exit(1);

} 
}
