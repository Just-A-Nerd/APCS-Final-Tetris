import java.util.ArrayList;

public class PlayingField
{
	private static int height = 22;
	private static int width = 10;
	private static BlockSquare[][] field = new BlockSquare[height][width];
	private static int numBlockSpecies = 5;
	private static int bufferCell =  2;
	private static ArrayList<Block> initList = new ArrayList<Block>();
	private static ArrayList<Block> randList = new ArrayList<Block>();
	
	public static BlockSquare[][] getField()
	{
		return field;
	}
	
	public static int getBuffer()
	{
		return bufferCell;
	}
	
	public static Block computeRandom()
	{
		if(randList.size() == 0)
		{
			initList.add(new BlockL());
			initList.add(new BlockJ());
			initList.add(new BlockT());
			initList.add(new BlockS());
			initList.add(new BlockZ());
			for(int i = 0; i < numBlockSpecies; i++)
			{
				int rand = (int) (Math.random() * numBlockSpecies);
				randList.add(initList.get(rand));
				initList.remove(rand);
			}
		}
		
		Block block = randList.get(0);
		randList.remove(0);
		
		return block;
	}
	
	public static void makeBlockAppear()
	{
		/*Block block = null;
		int rand = (int) (Math.random() * numBlockSpecies);
		
		switch(rand)
		{
		case 0: block = new BlockL();
		break;
		case 1: block = new BlockJ();
		break;
		case 2: block = new BlockT();
		break;
		case 3: block = new BlockS();
		break;
		case 4: block = new BlockZ();
		}*/
		
		Block block = computeRandom();
		
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
	
	public static void hitBottom()
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
	
	public static int clearLines()
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
