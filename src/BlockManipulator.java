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
		
	}
	
	public static void spinRight()
	{
		
	}
}