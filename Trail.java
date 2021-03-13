package olwave;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import olwave.GameObject;
import olwave.Handler;
import olwave.Type;

public class Trail extends GameObject {
	
	private float alpha=1;
	private Handler handler;
	private Color color;
	private int width; 
	private int height;
	private float life;

		public Trail(int x, int y, Type type, Color color, int width, int height, float life, Handler handler) {
			super(x, y, type);
			// TODO Auto-generated constructor stub
			this.color=color;
			this.width=width;
			this.height=height;
			this.life=life;
			this.handler=handler;
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			if (alpha>life)
			{alpha-=(life-0.0001f);}
			else
				handler.removeObject(this);
		}

		@Override
		public void render(Graphics graphics) {
			// TODO Auto-generated method stub
			Graphics2D g2 = (Graphics2D) graphics;
			g2.setComposite(makeTransparent(alpha));
	graphics.setColor(color);
	graphics.fillRect((int)x,(int)y,width,height);
	g2.setComposite(makeTransparent(1));
		}

		@Override
		public Rectangle getBounds() {
			// TODO Auto-generated method stub
			return null;
		}

		private AlphaComposite makeTransparent (float alpha) {
			
			int t=AlphaComposite.SRC_OVER;
			return AlphaComposite.getInstance(t,alpha);
		}
		
}