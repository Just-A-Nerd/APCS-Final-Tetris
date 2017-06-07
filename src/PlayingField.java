import java.util.ArrayList;

public class PlayingField
{
	private static int bufferCell =  2;
	private static int height = 20 + bufferCell;
	private static int width = 10;
	private static BlockSquare[][] field = new BlockSquare[height][width];
	//private static int numBlockSpecies = 14;
	static ArrayList<Block> initList = new ArrayList<Block>();
	static ArrayList<Block> randList = new ArrayList<Block>();
	private static boolean isGameOver = false;
	private static Block nextBlock = null;
	private static Block currentBlock = null;
	private static int gameType = 1;
	
	public static BlockSquare[][] getField()
	{
		return field;
	}
	
	public static void setGameType(int t)
	{
		gameType = t;
	}
	
	public static void resetRandLists()
	{
		initList = new ArrayList<Block>();
		randList = new ArrayList<Block>();
		nextBlock = null;
		System.out.println("asdfaa");
	}
	
	public static Block computeRandom()
	{
		if(randList.size() == 0)
		{
			System.out.println(gameType);
			if(gameType == 1 || gameType == 2)
			{
				initList.add(new BlockL());
				initList.add(new BlockJ());
				initList.add(new BlockT());
				initList.add(new BlockS());
				initList.add(new BlockZ());
				initList.add(new BlockO());
//				initList.add(new BlockI());
			}
			if(gameType == 1 || gameType == 3)
			{
				initList.add(new Block5F());
				initList.add(new Block5P());
				initList.add(new Block5T());
				initList.add(new Block5U());
				initList.add(new Block5W());
				initList.add(new Block5X());
				initList.add(new Block5Z());
				initList.add(new Block5FB());
				initList.add(new Block5PB());
				initList.add(new Block5ZB());
				//initList.add(new Block5I());
			}
			for(int i = 0; i < initList.size(); i++)
			{
				int rand = (int) (Math.random() * initList.size());
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
		//block = new BlockT();
		//Block block = computeRandom();
		
		if(nextBlock == null)
			nextBlock = computeRandom();
		
		Block block = nextBlock;
		currentBlock = block;
		
		for(int i = 0; i < block.getBlockArray().length; i++)
		{
			int mid = field[0].length / 2;

			for(int j = 0; j < block.getBlockArray()[0].length; j++)
			{
				if(field[bufferCell + i][mid - (block.getBlockArray()[0].length / 2) + j] != null)
				{
					isGameOver = true;
					System.out.println("gameover");
				}
				
				if(block.getBlockArray()[i][j] != null)
				{
					field[bufferCell + i][mid - (block.getBlockArray()[0].length / 2) + j] = block.getBlockArray()[i][j];
				}
			}
		}
		nextBlock = computeRandom();
	}
	
	public static boolean doesHitBottom()
	{
		boolean isHit = false;
		for(int i = 0; i < field.length; i++)
		{
			for(int j = 0; j < field[0].length; j++)
			{
				if(field[i][j] != null && field[i][j].getName() != "x")
				{
					if(i == field.length - 1 || (field[i+1][j] != null && field[i+1][j].getName() == "x"))
					{
						//found a BlockSquare that is at hit something
						isHit = true;	
					}
				}
			}
		}
		return isHit;
	}
	
	public static void hitBottom()
	{
		for(int k = 0; k < field.length; k++)
		{
			for(int m = 0; m < field[0].length; m++)
			{
				if(field[k][m] != null && field[k][m].getName() != "x")
				{
					//System.out.println("hitb1");
					
					field[k][m].setName("x");
					field[k][m].setAxisOfRotation(false);
					//System.out.println("hitb2");
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
				for(int k = i; k > 0; k--)
				{
					for(int j = 0; j < field[0].length; j++)
					{
						field[k][j] = field[k-1][j];
					}
				}
			}	
		}
		return count;
	}
	
	public static int getBuffer()
	{
		return bufferCell;
	}
	
	public static Block getNextBlock()
	{
		return nextBlock;
	}
	
	public static Block getCurrentBlock()
	{
		return currentBlock;
	}
	
	public static void resetArray()
	{
		field = new BlockSquare[height][width];
	}
	
	public static boolean isGameOver()
	{
		return isGameOver;
	}
	
	public static void setGameOver(boolean isGO)
	{
		isGameOver = isGO;
	}
}