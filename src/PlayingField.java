public class PlayingField
{
	private static int height = 16;
	private static int width = 12;
	private BlockSquare[][] field = new BlockSquare[height][width];
	private int numBlockSpecies = 1;
	
	public BlockSquare[][] getField()
	{
		return field;
	}
	
	public void makeBlockAppear()
	{
		Block block = null;
		int rand = (int) (Math.random() * numBlockSpecies) + 1;
		switch(rand)
		{
		case 1: block = new BlockL();
		break;
		}
		
		for(int i = 0; i < field.length; i++)
		{
			int mid = field[0].length / 2;
			
			//for(int j = mid - block.getMaxLength(); j < field[0].length; j++)
			//{
				
			//}
		}
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
