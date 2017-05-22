import java.awt.Color;

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
	
	public static int getBuffer() {
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
	
	
	public static void changeField()
	{
		field[3][1] = new BlockSquare(new Color(200,200,0), new Color(100,100,0), "L");
		field[21][9] = new BlockSquare(new Color(255,0,0), new Color(150,0,0), "T");
		field[10][5] = new BlockSquare(new Color(50,200,0), new Color(25,150,0), "Z");
		field[17][3] = new BlockSquare(new Color(0,100,200), new Color(0,50,100), "S");
		
	}
}
