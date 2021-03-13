package olwave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class MenuParticle extends GameObject {

	
	private Handler handler;
	Random r = new Random();
	
	private Color col;
	int dir=0;
	public MenuParticle(int x, int y, Type type,  Handler handler) {
		super(x, y, type);
		
		this.handler=handler;
		dir= r.nextInt(2);
		if (dir==0)
		{
				
		dx=2;
		dy=5;
		}
		else if (dir==1)
		{
			
			dx=5;
			dy=2;
			}
				
		col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		

		
		
		
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

	@Override
	public void tick() {
		
		x += dx;
		y += dy;
		
		 if( y<=0 || y >= 750 - 14) dy *= -1;
		 if( x<=0 || x >= 1000 - 14) dx *= -1;
		 handler.addObject(new Trail((int)x, (int)y, Type.Trail, col, 16, 16, 0.01f, handler));
		
	}

	@Override
	public void render(Graphics graphics) {
		
		

		graphics.setColor(col);
		graphics.fillRect((int)x, (int)y, 14, 14);
	}

	
}
