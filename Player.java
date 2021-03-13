package olwave;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;

	public Player(int x, int y, Type type, Handler handler) {
		super(x, y, type);
		
		this.handler = handler;
	}

	private void collision()
	{ 
		if(this.getType() == Type.Player) {
		for(int i=0; i<handler.gameObject.size() ; i++)
		{
			GameObject object = handler.gameObject.get(i);
			
			if(object.getType() == Type.Enemy || object.getType() == Type.fastEnemy)
			{
				if(getBounds().intersects(object.getBounds()))
				{
					HUD.health1 -= 2;
				}
			}
		}}
		
		
	}

	public void tick() {
		x += dx;
		y += dy;
		
		x = Game.clamp((int)x, 0, 1000 - 32);
		y = Game.clamp((int)y, 0, 750 - 32);
		collision();
	}
	
	
	
	public void render(Graphics graphics) {
		
         if(this.type == Type.Player) {
			graphics.setColor(Color.white); 
			graphics.fillRect((int)x,(int)y,32,32);
			}
       
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	

}
