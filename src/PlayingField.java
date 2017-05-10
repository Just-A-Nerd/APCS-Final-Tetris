public class PlayingField
{
	private static int height = 22;
	private static int width = 10;
	private BlockSquare[][] field = new BlockSquare[height][width];
	private int numBlockSpecies = 1;
	private int bufferCell =  2;
	
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
		
		for(int i = bufferCell; i < block.getBlockArray().length; i++)
		{
			int mid = field[0].length / 2;
			
			for(int j = mid - block.getBlockArray()[0].length; j < field[0].length; j++)
			{
				if(block.getBlockArray()[i][j] != null)
					field[i][j] = block.getBlockArray()[i][j];
			}
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
