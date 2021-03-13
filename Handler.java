package olwave;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> gameObject = new LinkedList<GameObject>();
	
	public void tick()
	{
		for(int i=0; i<gameObject.size();i++)
		{
			GameObject currOb = gameObject.get(i);
			
			currOb.tick();
		}
	}
	
	public void render(Graphics graphics)
	{
		for(int i=0; i<gameObject.size();i++)
		{
			GameObject currOb = gameObject.get(i);
			
			currOb.render(graphics);
		}
	}
	
	public void addObject(GameObject object)
	{
		this.gameObject.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.gameObject.remove(object);
	}
	
	public void clearEnemys() {
		for(int i =0; i<gameObject.size(); i++) {
			GameObject tempObject = gameObject.get(i);

			if(tempObject.getType() == Type.Player) {
				 gameObject.clear();
				 if (Game.gamestate != Game.state.End)
					 addObject(new Player(100, 100, Type.Player, this));	 
		}

}
	}
}
