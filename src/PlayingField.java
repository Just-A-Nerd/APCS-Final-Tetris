public class PlayingField
{
	private static int height = 16;
	private static int width = 12;
	private BlockSquare[][] field = new BlockSquare[height][width];
	
	public BlockSquare[][] getField()
	{
		return field;
	}
	
	public void makeBlockAppear()
	{
		
	}
	
	public void clearLines()
	{
		
	}
	public static int getHeight()
	{ 
		return height;
	}
	public static int getWidth()
	{
		return width;
	}
}
