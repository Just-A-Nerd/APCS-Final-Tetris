public class BlockManipulator
{
	private static int blockPos = 0;
	
	public static void Move(String direction)
	{
		boolean canMove = true;

		int moveCount = 0;
		
		if(PlayingField.doesHitBottom())
			return;
		
		if(direction.equals("down"))
		{
			for(int i = PlayingField.getField().length - 1; i >= 0; i--)
			{
				for(int j = 0; j < PlayingField.getField()[0].length; j++)
				{
					//checks if the current blocksquare is the falling block
					if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].getName() != "x")
					{
						if(moveCount >= 5)
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
						if(moveCount >= 5)
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
						if(moveCount >= 5)
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
		int axisCount = 0;
		//int blockPos = 0;
		for(int i = 0; i < PlayingField.getField().length; i++)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].isAxisOfRotation())
					axisCount++;
			}
		}
		
		for(int i = 0; i < PlayingField.getField().length; i++)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				if(axisCount == 1) //3x3 or 5x5 rotation
				{
					//checks if the current blocksquare is the axis of rotation of the falling block
					if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].isAxisOfRotation())
					{
						if(!PlayingField.getField()[i][j].getName().equals("5I"))
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
						else //5I block only
						{
							boolean canSpin = true;
							
							for(int k = 0; k < 5; k++)
							{
								for(int m = 0; m < 5; m++)
								{
									if(PlayingField.getField()[i-2+k][j-2+m] == null || PlayingField.getField()[i-2+k][j-2+m].getName() != "x")
									{}
									else
										canSpin = false;
								}
							}
							
							if(canSpin)
							{
							if(blockPos == 0)
							{
								PlayingField.getField()[i-2][j] = PlayingField.getField()[i][j-2];
								PlayingField.getField()[i-1][j] = PlayingField.getField()[i][j-1];
								PlayingField.getField()[i+1][j] = PlayingField.getField()[i][j+1];
								PlayingField.getField()[i+2][j] = PlayingField.getField()[i][j+2];
								
								PlayingField.getField()[i][j-2] = null;
								PlayingField.getField()[i][j-1] = null;
								PlayingField.getField()[i][j+1] = null;
								PlayingField.getField()[i][j+2] = null;
							}
							
							if(blockPos == 1)
							{
								System.out.println("werwer");
								PlayingField.getField()[i][j-2] = PlayingField.getField()[i-2][j];
								PlayingField.getField()[i][j-1] = PlayingField.getField()[i-1][j];
								PlayingField.getField()[i][j+1] = PlayingField.getField()[i+1][j];
								PlayingField.getField()[i][j+2] = PlayingField.getField()[i+2][j];
								
								PlayingField.getField()[i-2][j] = null;
								PlayingField.getField()[i-1][j] = null;
								PlayingField.getField()[i+1][j] = null;
								PlayingField.getField()[i+2][j] = null;
							}
							
							if(blockPos == 0)
								blockPos = 1;
							else if(blockPos == 1)
								blockPos = 0;
							}
						}
					}
				}
				
				if(axisCount == 4)
				{
					//O block; do nothing!!!
				}
				
				if(axisCount == 2 || axisCount == 3) //4x4 rotation
				{
					String axisPos = null;
					//checks if the current blocksquare is the axis of rotation of the falling block
					if(PlayingField.getField()[i][j] != null && PlayingField.getField()[i][j].isAxisOfRotation())
					{
						System.out.println("weoiurou");
						if(PlayingField.getField()[i][j].getName().equals("I"))
						{
							/*
							 * u = up
							 * l = left
							 * d = down
							 * r = right
							 */
							System.out.println(blockPos);
							switch(blockPos)
							{
								case 0: axisPos = "tl";
								break;
								case 1: axisPos = "tr";
								break;
								case 2: axisPos = "tl";
								break;
								case 3: axisPos = "tl";
								break;
							}
						}
						
						System.out.println(axisPos);
						
						int tempW = 4;
						int tempH = 4;
						boolean canSpin = true;
						BlockSquare[][] temp = new BlockSquare[tempH][tempW];
						
						//copies current block blocksquares into temp array; determines if spin can happen
						for(int k = 0; k < tempH; k++)
						{
							for(int m = 0; m < tempW; m++)
							{
								if(axisPos.equals("tl"))
								{
									if(PlayingField.getField()[i-1+k][j-1+m] == null || PlayingField.getField()[i-1+k][j-1+m].getName() != "x")
										temp[k][m] = PlayingField.getField()[i-1+k][j-1+m];
									else
										canSpin = false;
								}
								
								
								if(axisPos.equals("tr"))
								{
									if(PlayingField.getField()[i-1+k][j-2+m] == null || PlayingField.getField()[i-1+k][j-2+m].getName() != "x")
										temp[k][m] = PlayingField.getField()[i-1+k][j-2+m];
									else
										canSpin = false;
								}
								
							}
						}
						if(canSpin)
						{
							if(direction.equals("right"))
							{
								if(axisPos.equals("tl"))
								{
									System.out.println("top left -> right");
									//sets left to top
									PlayingField.getField()[i-1][j+1] = temp[1][1-1];
									PlayingField.getField()[i-1][j] = temp[1+1][1-1];
									
									//sets top to right
									PlayingField.getField()[i][j+2] = temp[1-1][1];
									PlayingField.getField()[i+1][j+2] = temp[1-1][1+1];
									
									//sets right to bottom
									PlayingField.getField()[i+2][j+1] = temp[1][1+2];
									PlayingField.getField()[i+2][j] = temp[1+1][1+2];
									
									//sets bottom to left
									PlayingField.getField()[i][j-1] = temp[1+2][1];
									PlayingField.getField()[i+1][j-1] = temp[1+2][1+1];
									
									//no need to rotate corners; no blocks use them
									
									//axises of rotation
									PlayingField.getField()[i][j+1] = temp[1][1];
									PlayingField.getField()[i+1][j+1] = temp[1][1+1];
									PlayingField.getField()[i+1][j] = temp[1+1][1+1];
									//set current axis of rotation
									PlayingField.getField()[i][j] = temp[1+1][1];
									
									blockPos++;
								}
								
								
							}
							
							else if(direction.equals("left"))
							{
								if(axisPos.equals("tr"))
								{
									System.out.println("top right -> left");
									//sets left to bottom
									PlayingField.getField()[i+2][j] = temp[1][1-1];
									PlayingField.getField()[i+2][j+1] = temp[1+1][1-1];
									
									//sets bottom to right
									PlayingField.getField()[i+1][j+2] = temp[1+2][1];
									PlayingField.getField()[i][j+2] = temp[1+2][1+1];
									
									//sets right to top
									PlayingField.getField()[i-1][j] = temp[1][1+2];
									PlayingField.getField()[i-1][j+1] = temp[1+1][1+2];
									
									//sets top to left
									PlayingField.getField()[i+1][j-1] = temp[1-1][1];
									PlayingField.getField()[i][j-1] = temp[1-1][1+1];
									
									//no need to rotate corners; no blocks use them
									
									//axises of rotation
									PlayingField.getField()[i][j+1] = temp[1][1];
									PlayingField.getField()[i+1][j+1] = temp[1][1+1];
									PlayingField.getField()[i+1][j] = temp[1+1][1+1];
									//set current axis of rotation
									PlayingField.getField()[i][j] = temp[1+1][1];
									
									blockPos--;
								}
							}
							
							if(blockPos == 3)
								blockPos = 0;
							else
								;
							if(blockPos == -1)
							{
								blockPos = 3;
							}
							
							return;
						}
					}
				}
			}
		}
	}
}