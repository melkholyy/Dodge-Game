package olwave;

import java.util.Random;

public class spawn {
	private Handler handler;
	private HUD hud;
	private int scorekeep=0;
	private Random r = new Random();
	public spawn (Handler handler, HUD hud)
	{
		this.handler= handler;
		this.hud = hud;
		
	}
public void tick() {
	
	scorekeep++;
	if (scorekeep>=100)
	{
	scorekeep=0;
	hud.setlevel(hud.getlevel()+1);
	
	
	
	if (hud.getlevel()==2)
		handler.addObject(new Enemy(100, 10, Type.Enemy,handler));

	
	else if (hud.getlevel()==3)
	{
		handler.addObject(new fastEnemy(500,700,Type.fastEnemy,handler));
		
	}
	

	
}
	

}

	

}
