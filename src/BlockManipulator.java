public class BlockManipulator
{
	public static void moveLeft()
	{
		boolean canMove = true;
		for(int i = 0; i < PlayingField.getField().length; i++)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				if(PlayingField.getField()[i][j].getName() != "x")
				{
					if(j == 0)
						canMove = false;
					if(PlayingField.getField()[i][j-1] != null)
						canMove = false;
				}
			}
		}
			
		if(canMove)
		{
			for(int i = 0; i < PlayingField.getField().length; i++)
			{
				for(int j = 0; j < PlayingField.getField()[0].length; j++)
				{
					if(PlayingField.getField()[i][j].getName() != "x")
					{
						PlayingField.getField()[i][j-1] = PlayingField.getField()[i][j];
						PlayingField.getField()[i][j] = null;
					}
				}
			}
		}
	}
	
	public static void moveRight()
	{
		
	}
	
	public static void moveDown()
	{
		
	}
	
	public static void spinLeft()
	{
		for(int i = 0; i < PlayingField.getField().length; i++)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				if(PlayingField.getField()[i][j].isAxisOfRotation())
				{
					int tempW = 3;
					int tempH = 3;
					BlockSquare[][] temp = new BlockSquare[3][3];
					
					for(int k = 0; k < tempH; k++)
					{
						for(int m = 0; m < tempW; m++)
						{
							temp[k][m] = PlayingField.getField()[i-1+k][j-1+m];
						}
					}
					
					//sets left to top
					PlayingField.getField()[i-1][j-1] = temp[i+1][j-1];
					PlayingField.getField()[i][j-1] = temp[i+1][j];
					PlayingField.getField()[i+1][j-1] = temp[i+1][j+1];
				}
			}
		}
	}
	
	public static void spinRight()
	{
		
	}
}