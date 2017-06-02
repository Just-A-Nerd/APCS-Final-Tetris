import java.util.Timer;
import java.util.TimerTask;

public class Game
{
	private static Timer timer = new Timer();
	static boolean isPaused = false;
	private static boolean genBlock;
	private static final int LEVEL1_SPEED = 1000;
	private static final int NEXT_LEVEL_SPEED_INC1 = 100;
	private static final int NEXT_LEVEL_SPEED_INC2 = 10;
	private static int currentSpeed = LEVEL1_SPEED;
	private static TimerTask task;
	
	public static void Update()
	{
		//put stuff here to make it run repeatedly without delay
	}
	
	public static void downLoop()
	{
		timer = new Timer();
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
						
						//PointCounter.setLevel(PointCounter.getLevel()+1);
						//changeTimer();
					}
					
					int numLines = PlayingField.clearLines();
					PointCounter.addLinePoints(numLines);
					
					BlockManipulator.Move("down");
					
					if(genBlock)
						PlayingField.makeBlockAppear();
					
					System.out.println(currentSpeed);
					
					
				}
			}
		}, currentSpeed, currentSpeed);
	}
	
	public static void changeTimer()
	{
		timer.cancel();
		if(PointCounter.getLevel() <= 10)
			currentSpeed -= NEXT_LEVEL_SPEED_INC1;
		else if(PointCounter.getLevel() > 10 && PointCounter.getLevel() < 19)
			currentSpeed -= NEXT_LEVEL_SPEED_INC2;
		downLoop();
	}
	
	public static void Reset()
	{
		PlayingField.setGameOver(false);
		currentSpeed = LEVEL1_SPEED;
		PlayingField.resetArray();
		PointCounter.resetPointCounter();
		PlayingField.makeBlockAppear();
		
	}
	
	public static void Pause()
	{
		isPaused = !isPaused;
	}
}