public class PlayingField
{
	private static int height = 22;
	private static int width = 10;
	private static BlockSquare[][] field = new BlockSquare[height][width];
	private int numBlockSpecies = 1;
	private static int bufferCell =  2;
	
	public static BlockSquare[][] getField()
	{
		return field;
	}
	
	public static int getBuffer()
	{
		return bufferCell;
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
	
	public void hitBottom()
	{
		for(int i = 0; i < field.length; i++)
		{
			for(int j = 0; j < field[0].length; j++)
			{
				if(field[i][j] != null && field[i][j].getName() != "x")
				{
					if(i == field.length - 1 || field[i-1][j] != null)
					{
						field[i][j].setName("x");
						field[i][j].setAxisOfRotation(false);
					}
				}
			}
		}
	}
	
	public int clearLines()
	{
		int count = 0;
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
				
				count++;
				
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
		return count;
	}
}
