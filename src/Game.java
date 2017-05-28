import java.util.Timer;
import java.util.TimerTask;

public class Game
{
	static boolean isPaused = false;
	private static boolean genBlock;
	private static final int LEVEL1_SPEED = 1000;
	private static final int NEXT_LEVEL_SPEED_INC = 100;
	//private static int currentSpeed = LEVEL1_SPEED - (NEXT_LEVEL_SPEED_INC * (PointCounter.getLevel() - 1));
	
	public static void Update()
	{
		//put stuff here to make it run repeatedly without delay
		//currentSpeed = LEVEL1_SPEED - (NEXT_LEVEL_SPEED_INC * (PointCounter.getLevel() - 1));
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
		}, 1000, 1000);
	}
	
	public static void Pause()
	{
		isPaused = !isPaused;
	}
}