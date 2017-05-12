public class BlockManipulator
{
	public static void moveLeft()
	{
		boolean canMove = true;
		for(int i = 0; i < PlayingField.getField().length; i++)
		{
			for(int j = 1; j < PlayingField.getField()[0].length; j++)
			{
				if(PlayingField.getField()[i][j].getName() != "x")
				{
					if(PlayingField.getField()[i][j-1] != null)
						canMove = false;
				}
			}
		}
			
		if(canMove)
		{
			for(int i = 0; i < PlayingField.getField().length; i++)
			{
				for(int j = 1; j < PlayingField.getField()[0].length; j++)
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
		System.out.println("Block spinning left");
	}
	
	public static void spinRight()
	{
		System.out.println("Block spinning right");
	}
}