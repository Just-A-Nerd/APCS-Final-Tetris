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
		
		/*genBlock = false;
		if(PlayingField.hitBottom())
			genBlock = true;
		
		if(genBlock)
			PlayingField.makeBlockAppear();*/
	}
	
	public static void downLoop()
	{
		PlayingField.makeBlockAppear();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if(!isPaused && !KeyboardListener.isTitleScreen())
				{
					genBlock = false;
					if(PlayingField.doesHitBottom())
					{
						PlayingField.hitBottom();
						genBlock = true;
					}
					
					int numLines = PlayingField.clearLines();
					PointCounter.addLinePoints(numLines);
					
					BlockManipulator.Move("down");
					
					if(genBlock)
						PlayingField.makeBlockAppear();
					
					System.out.println("test");
				}
			}
		}, 1000, 1000);
	}
	
	public static void Reset()
	{
		PlayingField.setGameOver(false);
		PlayingField.resetArray();
		PointCounter.resetPointCounter();
		PlayingField.makeBlockAppear();
	}
	
	public static void Pause()
	{
		isPaused = !isPaused;
	}
}