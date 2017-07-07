import java.util.Timer;
import java.util.TimerTask;

public class Flash
{
	private static Timer timer = new Timer();
	private static int interval = 400;
	private static boolean state = true;
	
	public static void flashLoop()
	{
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				state = !state;
			}
		}, interval, interval);
	}
	
	public static void cancelTimer()
	{
		timer.cancel();
	}
	
	public static boolean getState()
	{
		return state;
	}
}