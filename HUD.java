package olwave;
import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int health1 = 100;
	
	private int greenValue=255;
private int score=0;
private int level=1;
	public void tick()
	{
		health1 = (int) Game.clamp(health1, 0, 100);
		greenValue=(int) (health1*2);
		score++;
	}
	
	public void render(Graphics graphics)
	{
		//Player health bar
		graphics.setColor(Color.gray);
		graphics.fillRect(16, 16, 200, 32);
		graphics.setColor(new Color(75, greenValue, 0));
		graphics.fillRect(16, 16, (int) (health1 * 2), 32);
		graphics.fillRect(15, 15, (int) (health1*2), 32);
		graphics.setColor(Color.white);
		graphics.drawRect(16,16,200,32);
		graphics.drawString("Score "+ score,15,64);
		graphics.drawString("Level "+ level,15,84);
		}
	
	public void score(int score)
	{
	this.score=score;
	}
	
	public int getScore()
{
		return score;
		
}
	
	
	public int getlevel()
{
		return level;
		
}
	public void setlevel(int level)
	{
	this.level=level;
	}
}
