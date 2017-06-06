public class PointCounter
{
	private static int points = 0;
	private static int linesCleared = 0;
	private static boolean gotTetris = false;
	private static int level = 1;
	private static int nextLevelLines = 10;
	private static final int LINES_1 = 100;
	private static final int LINES_2 = 300;
	private static final int LINES_3 = 500;
	private static final int LINES_4 = 800;
	
	public static void addLinePoints(int lines)
	{
		linesCleared += lines;
		
		switch(lines)
		{
			case 1: points += LINES_1 * level;
			break;
			case 2: points += LINES_2 * level;
			break;
			case 3: points += LINES_3 * level;
			break;
			case 4: points += LINES_4 * level;
			
			/*if(gotTetris)
				points += 400 * level;
			
			gotTetris = true;
			break;*/
		}
		
		if(linesCleared >= nextLevelLines * level)
		{
			level++;
			Game.changeTimer();
		}
	}
	
	public static int getPoints()
	{
		return points;
	}
	
	public static int getLevel()
	{
		return level;
	}
	
	public static int getLinesCleared()
	{
		return linesCleared;
	}
	
	public static void gotTetris(boolean isTrue)
	{
		gotTetris = isTrue;
	}
	
	public static void resetPointCounter()
	{
		points = 0;
		level = 1;
		linesCleared = 0;
	}
	
	public static void setLevel(int l)
	{
		level = l;
	}
}
