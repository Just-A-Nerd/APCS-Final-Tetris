import java.util.Timer;
import java.util.TimerTask;

public class Game
{
	static int x = 0;
	static int level1Speed = 1000;
	
	public static void Update()
	{
		if(x == 0)
		{
			PlayingField.makeBlockAppear();
			x = 1;
		}
		
		PlayingField.hitBottom();
	}
	
	public static void downLoop()
	{
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				BlockManipulator.Move("down");
				System.out.println("test");
			}
		}, level1Speed, level1Speed);
	}
}