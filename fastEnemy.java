package olwave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class fastEnemy extends GameObject {

	
	private Handler handler;
	
	
	public fastEnemy(int x, int y, Type type,  Handler handler) {
		super(x, y, type);
		
		this.handler=handler;
		dx=2;
		dy=8;
		
		
		
		
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
		 handler.addObject(new Trail((int)x, (int)y, Type.Trail, Color.BLUE, 16, 16, 0.01f, handler));
		
	}

	@Override
	public void render(Graphics graphics) {
		
		

		graphics.setColor(Color.BLUE);
		graphics.fillRect((int)x, (int)y, 14, 14);
	}

	
}
