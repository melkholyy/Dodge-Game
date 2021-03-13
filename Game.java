package olwave;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	
	private Thread thread;
	private boolean isRunning = false;
	private String title = "Dodge!";
	public int width = 1000;
	public int height = 750;
	private Random r;
	private Handler handler;
	private HUD hud;
	private spawn spawner;
	private Menu menu;
	public enum state
	{
	Menu,
	Game,
	Help,
	End
	};
	public static state gamestate= state.Menu;
	
	
	public Game() {
		
		
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler,hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new WindowClass(this.width, this.height, this.title, this);
		
		spawner = new spawn(handler, hud);
		
		
		r = new Random();

		if(gamestate==state.Game)
		{
		
		
		handler.addObject(new Player(100, 100, Type.Player, handler));

		handler.addObject(new Enemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),Type.Enemy,handler));
		}

		
		else {
			for(int i=0; i<15;i++)
			{
				handler.addObject(new MenuParticle(r.nextInt(700),r.nextInt(1000),Type.MenuParticle,handler));
				
			}
		}
		
		

		
		
	}

	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	public synchronized void end()
	{
		try {
			thread.join();
			isRunning = false;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();
		long previousTime = System.nanoTime();
		double ticks = 60.0;
		double ns = 1000000000/ticks;
		double delta = 0;
		long Timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning)
		{
			long currentTime = System.nanoTime();
			delta = delta + (currentTime - previousTime) / ns;
			previousTime = currentTime;
			
			while(delta >= 1)
			{
				tick();
				delta--;
			}
			
			if(isRunning)
				render();
			
			frames++;
			
			if(System.currentTimeMillis() - Timer > 1000)
			{
				Timer = Timer + 1000;
				frames = 0;
			}
		}
		end();
	}
	
	private void tick() {
		handler.tick();
		if(gamestate==state.Game)
		{
		hud.tick();
		spawner.tick();
		if (HUD.health1<=0)
			
		{
		HUD.health1= 100;
		
		gamestate= state.End;
		handler.clearEnemys();
		
		for(int i=0; i<15;i++)
		{
			handler.addObject(new MenuParticle(r.nextInt(700),r.nextInt(1000),Type.MenuParticle,handler));
			
		}
			
		}
		
	}
		
		
		else if(gamestate==state.Menu|| gamestate==state.End)
			
		{
			
		menu.tick();
	}
	}
	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		
		if(buffer == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = buffer.getDrawGraphics();
		graphics.setColor(Color.black);
		graphics.fillRect(0,0, (int) this.width,(int) this.height );
		handler.render(graphics);
		
		if(gamestate==state.Game)
		{
		
		hud.render(graphics);
		}
else if(gamestate==state.Menu || gamestate== state.Help|| gamestate==state.End)
			
		{
			
		menu.render(graphics);
	}
		
		graphics.dispose();
		buffer.show();
	}
	
	public static float clamp(float var, float min, float max)
	{
		if(var >= max)
			return var = max;
		
		else if(var <= min)
			return var = min;
		
		else return var;
	}
	public static void main(String[] args)
	{
		new Game();
	}
	
}
