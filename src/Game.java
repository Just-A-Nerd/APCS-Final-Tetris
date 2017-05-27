import java.util.Timer;
import java.util.TimerTask;

public class Game
{
	static boolean isPaused = false;
	static boolean genBlock;
	static int level1Speed = 1000;
	static int level2Speed = 900;
	static int level3Speed = 800;
	static int level4Speed = 700;
	static int level5Speed = 600;
	static int level6Speed = 500;
	static int level7Speed = 400;
	static int level8Speed = 300;
	static int level9Speed = 200;
	
	public static void Update()
	{
		
	}
	
	public static void downLoop()
	{
		PlayingField.makeBlockAppear();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if(!isPaused)
				{
					genBlock = false;
					if(PlayingField.hitBottom())
						genBlock = true;
					
					PlayingField.clearLines();
					
					if(genBlock)
						PlayingField.makeBlockAppear();
					
					BlockManipulator.Move("down");
					System.out.println("test");
				}
			}
		}, level1Speed, level1Speed);
	}
	
	public static void Pause()
	{
		isPaused = !isPaused;
	}
}