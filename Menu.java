package olwave;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import olwave.Game.state;
public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	public Menu(Game game, Handler handler, HUD hud)
	{
		this.game=game;
		this.handler=handler;
		this.hud =hud;
	}
	
public void mousePressed(MouseEvent e)
{
	int mx=e.getX();
	int my=e.getY();
	
if (Game.gamestate==state.Menu)
		
	{
	if (mouseOver(mx, my, 350, 250, 250, 64))
	{
		Game.gamestate=state.Game;
		handler.addObject(new Player(100, 100, Type.Player, handler));
		handler.clearEnemys();
		handler.addObject(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),Type.Enemy,handler));
	
	
	}
	
	else if (mouseOver(mx, my, 350, 450, 250, 64))
		
	{
		
		System.exit(1);
	}
	
	else if (mouseOver(mx, my, 350, 350, 250, 64))
		
	{
		
		Game.gamestate=state.Help;
	}
		}
		
	
	

	
	if (Game.gamestate==state.Help)
		
	{
		if (mouseOver(mx, my,350, 450, 250, 150))
			
		{
			
			Game.gamestate=state.Menu;
			return;
		}
		
	}
	if (Game.gamestate==state.End)
		
	{
		if (mouseOver(mx, my,350, 450, 250, 150))
			
		{
			
			Game.gamestate=state.Game;
			hud.setlevel(1);
			hud.score(0);
			handler.addObject(new Player(100, 100, Type.Player, handler));
			handler.clearEnemys();
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),Type.Enemy,handler));
		
		
		}
		
	}
}

public void mouseReleased(MouseEvent e)
{
	

}
private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
{
	if (mx > x && mx < x+width)
	{
		if  (my > y && my < y+height)
		{
			
return true;
		}	
		else return false;
	}
	else return false;

}
public void tick()
{
	

}

public void render(Graphics g)
{
	if (Game.gamestate==state.Menu)
	{
		
		Font f = new Font("arial",1,100);
		Font f2 = new Font("arial",1,50);
		Font f3 = new Font("arial",1,50);
		Font f4 = new Font("arial",1,50);
		
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Menu", 365, 200);
		
		g.setFont(f2);
		g.setColor(Color.white);
		g.drawString("Play", 420, 300);
		
		g.setFont(f3);
		g.setColor(Color.white);
		g.drawString("Help", 420, 400);
		
		g.setFont(f4);
		g.setColor(Color.white);
		g.drawString("Quit", 420, 500);
		
		
		
	g.setColor(Color.white);	
	g.drawRect(350, 250, 250, 64);  

	g.setColor(Color.white);	
	g.drawRect(350, 350, 250, 64);

	g.setColor(Color.white);	
	g.drawRect(350, 450, 250, 64);
		
	} else if (Game.gamestate==state.Help)
	{
		Font f = new Font("arial",1,100);
		Font f2 = new Font("arial",1,25);
		
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("Help",350 , 100);
		
		g.setFont(f2);
		g.setColor(Color.white);
		g.drawString("Use the arrows to move player and escape from enemies",200 , 300);
		
		g.setFont(f);
		g.drawRect(350, 450, 250, 150);
		g.drawString("Back", 350, 550);
		
	}
	else if (Game.gamestate==state.End)
	{
		Font f = new Font("arial",1,50);
		Font f2 = new Font("arial",1,25);
		
		g.setFont(f);
		g.setColor(Color.white);
		g.drawString("GAME OVER",345 , 100);
		
		g.setFont(f2);
		g.setColor(Color.white);
		g.drawString("Your Score "+ hud.getScore(),360 , 300);
		
		g.setFont(f);
		g.drawRect(350, 450, 250, 150);
		g.drawString("Try Again", 350, 550);
		
	}


}
}
