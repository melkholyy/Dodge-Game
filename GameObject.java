package olwave;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x;
	protected float y;
	protected int dx;
	protected int dy;
	
	protected Type type;
	
	
	public GameObject(float x, float y, Type type)
	{
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public abstract void tick();
	public abstract void render(Graphics graphics);
	public abstract Rectangle getBounds();
	
	
	
	public void setX(float x)
	{
		this.x = x;
	}
	public void setY(float y)
	{
		this.y = y;
	}
	public float getX()
	{
		return this.x;
	}
	public float getY()
	{
		return this.y;
	}
	public void setType(Type type)
	{
		this.type = type;
	}
	public Type getType()
	{
		return this.type;
	}
	
	public void setDX(int dx)
	{
		this.dx = dx;
	}
	public void setDY(int dy)
	{
		this.dy = dy;
	}
	public int getDX()
	{
		return this.dx;
	}
	public int getDY()
	{
		return this.dy;
	}
}
