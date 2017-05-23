public class BlockManipulator
{
	public static void Move(String direction)
	{
		switch(PlayingField.)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				//checks if the current blocksquare is the falling block
				if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].getName() != "x")
				{
					if(direction.equals("left"))
					{
						if(j == 0)
							canMove = false;
						if(PlayingField.getField()[i][j-1] != null)
							canMove = false;
						
						if(canMove)
						{
							PlayingField.getField()[i][j-1] = PlayingField.getField()[i][j];
							PlayingField.getField()[i][j] = null;
						}
					}
					
					if(direction.equals("right"))
					{
						if(j == PlayingField.getField()[0].length - 1)
							canMove = false;
						if(PlayingField.getField()[i][j+1] != null)
							canMove = false;
						
						if(canMove)
						{
							PlayingField.getField()[i][j+1] = PlayingField.getField()[i][j];
							PlayingField.getField()[i][j] = null;
						}
					}
					
					if(direction.equals("down"))
					{
						if(i == PlayingField.getField().length - 1)
							canMove = false;
						if(PlayingField.getField()[i-1][j] != null)
							canMove = false;
						
						if(canMove)
						{
							PlayingField.getField()[i-1][j] = PlayingField.getField()[i][j];
							PlayingField.getField()[i][j] = null;
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
				if(PlayingField.getField()[i][j].isAxisOfRotation())
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
							if(PlayingField.getField() == null || PlayingField.getField()[i-1+k][j-1+m].getName() != "x")
								temp[k][m] = PlayingField.getField()[i-1+k][j-1+m];
							else
								canSpin = false;
						}
					}
					
					if(canSpin)
					{
						if(direction.equals("left"))
						{
							//sets left to top
							PlayingField.getField()[i][j-1] = temp[i+1][j];
					
							//sets bottom to left
							PlayingField.getField()[i-1][j] = temp[i][j-1];
						
							//sets right to bottom
							PlayingField.getField()[i][j+1] = temp[i-1][j];
					
							//sets top to right
							PlayingField.getField()[i+1][j] = temp[i][j+1];
					
							//corners
							PlayingField.getField()[i-1][j-1] = temp[i+1][j-1];
							PlayingField.getField()[i+1][j-1] = temp[i+1][j+1];
							PlayingField.getField()[i-1][j+1] = temp[i-1][j-1];
							PlayingField.getField()[i+1][j+1] = temp[i+1][j-1];
						}
						
						if(direction.equals("right"))
						{
							//sets left to top
							PlayingField.getField()[i+1][j] = temp[i][j-1];
					
							//sets bottom to left
							PlayingField.getField()[i][j-1] = temp[i-1][j];
						
							//sets right to bottom
							PlayingField.getField()[i-1][j] = temp[i][j+1];
					
							//sets top to right
							PlayingField.getField()[i][j+1] = temp[i+1][j];
					
							//corners
							PlayingField.getField()[i+1][j-1] = temp[i-1][j-1];
							PlayingField.getField()[i+1][j+1] = temp[i+1][j-1];
							PlayingField.getField()[i-1][j-1] = temp[i-1][j+1];
							PlayingField.getField()[i+1][j-1] = temp[i+1][j+1];
						}
					}
				}
			}
		}
	}
}