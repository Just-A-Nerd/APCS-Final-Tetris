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
		for(int i = 0; i < field.length; i++)
		{
			//check if line should be cleared
			boolean isFilled = true;
			for(int j = 0; j < field[0].length; j++)
			{
				if(field[i][j] == null)
					isFilled = false;
			}
			
			//clears line
			if(isFilled)
			{
				for(int j = 0; j < field[0].length; j++)
				{
					field[i][j] = null;
				}
			}
			
			//move everything above the cleared line down
			for(int k = i; k > 0; i--)
			{
				for(int j = 0; j < field[0].length; i++)
				{
					field[i][j] = field[i+1][j];
				}
			}
		}
	}
}
