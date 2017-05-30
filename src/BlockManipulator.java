public class BlockManipulator
{
	public static void Move(String direction)
	{
		boolean canMove = true;
		int moveCount = 0;
		
		if(direction.equals("down"))
		{
			for(int i = PlayingField.getField().length - 1; i >= 0; i--)
			{
				for(int j = 0; j < PlayingField.getField()[0].length; j++)
				{
					//checks if the current blocksquare is the falling block
					if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].getName() != "x")
					{
						if(moveCount >= 4)
							canMove = false;

						if(i == PlayingField.getField().length - 1)
							canMove = false;
						else if(PlayingField.getField()[i+1][j] != null)
							canMove = false;
						
						if(canMove)
						{
							PlayingField.getField()[i+1][j] = PlayingField.getField()[i][j];
							PlayingField.getField()[i][j] = null;
							moveCount++;
						}
					}	
				}
			}
		}
		
		else if(direction.equals("left"))
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				for(int i = 0; i < PlayingField.getField().length; i++)
				{
					//checks if the current blocksquare is the falling block
					if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].getName() != "x")
					{
						if(moveCount >= 4)
							canMove = false;
						
						if(j == 0)
							canMove = false;
						else if(PlayingField.getField()[i][j-1] != null)
							canMove = false;
						
						if(canMove)
						{
							PlayingField.getField()[i][j-1] = PlayingField.getField()[i][j];
							PlayingField.getField()[i][j] = null;
							moveCount++;
						}
					}
				}
			}
		}
			
		else if(direction.equals("right"))
		{
			for(int j = PlayingField.getField()[0].length - 1; j >= 0; j--)
			{
				for(int i = 0; i < PlayingField.getField().length; i++)
				{
					//checks if the current blocksquare is the falling block
					if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].getName() != "x")
					{
						if(moveCount >= 4)
							canMove = false;
						
						if(j == PlayingField.getField()[0].length - 1)
							canMove = false;
						else if(PlayingField.getField()[i][j+1] != null)
							canMove = false;
						
						if(canMove)
						{
							PlayingField.getField()[i][j+1] = PlayingField.getField()[i][j];
							PlayingField.getField()[i][j] = null;
							moveCount++;
						}
					}
				}
			}
		}
	}
	
	public static void Spin(String direction)
	{
		for(int i = 0; i < PlayingField.getField().length; i++)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				//checks if the current blocksquare is the axis of rotation of the falling block
				if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].isAxisOfRotation()/*PlayingField.getField()[i][j].getName() != "x"*/)
				{
					int tempW = 3;
					int tempH = 3;
					boolean canSpin = true;
					BlockSquare[][] temp = new BlockSquare[tempH][tempW];
					
					//copies current block blocksquares into temp array; determines if spin can happen
					for(int k = 0; k < tempH; k++)
					{
						for(int m = 0; m < tempW; m++)
						{
							if(PlayingField.getField()[i-1+k][j-1+m] == null || PlayingField.getField()[i-1+k][j-1+m].getName() != "x")
								temp[k][m] = PlayingField.getField()[i-1+k][j-1+m];
							else
								canSpin = false;
						}
					}
					
					if(canSpin)
					{
						if(direction.equals("right"))
						{
							//sets top to left
							PlayingField.getField()[i-1][j] = temp[1][1-1];
					
							//sets left to bottom
							PlayingField.getField()[i][j-1] = temp[1+1][1];
						
							//sets bottom to right
							PlayingField.getField()[i+1][j] = temp[1][1+1];
					
							//sets right to top
							PlayingField.getField()[i][j+1] = temp[1-1][1];
					
							//corners
							PlayingField.getField()[i+1][j-1] = temp[1+1][1+1];
							PlayingField.getField()[i-1][j-1] = temp[1+1][1-1];
							PlayingField.getField()[i-1][j+1] = temp[1-1][1-1];
							PlayingField.getField()[i+1][j+1] = temp[1-1][1+1];
						}
						
						else if(direction.equals("left"))
						{
							//sets top to left
							PlayingField.getField()[i][j-1] = temp[1-1][1];
					
							//sets left to bottom
							PlayingField.getField()[i+1][j] = temp[1][1-1];
						
							//sets bottom to right
							PlayingField.getField()[i][j+1] = temp[1+1][1];
					
							//sets right to top
							PlayingField.getField()[i-1][j] = temp[1][1+1];
					
							//corners
							PlayingField.getField()[i+1][j+1] = temp[1+1][1-1];
							PlayingField.getField()[i+1][j-1] = temp[1-1][1-1];
							PlayingField.getField()[i-1][j-1] = temp[1-1][1+1];
							PlayingField.getField()[i-1][j+1] = temp[1+1][1+1];
						}
					}
				}
			}
		}
	}
}