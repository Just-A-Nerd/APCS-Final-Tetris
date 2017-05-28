import java.util.Timer;
import java.util.TimerTask;

public class Game
{
	static boolean isPaused = false;
	private static boolean genBlock;
	private static boolean gameOver;
	private static int level1Speed = 1000;
	private static int level2Speed = 900;
	private static int level3Speed = 800;
	private static int level4Speed = 700;
	private static int level5Speed = 600;
	private static int level6Speed = 500;
	private static int level7Speed = 400;
	private static int level8Speed = 300;
	private static int level9Speed = 200;
	
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
					
					int numLines = PlayingField.clearLines();
					PointCounter.addLinePoints(numLines);
					
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