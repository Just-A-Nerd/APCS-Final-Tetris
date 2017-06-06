import java.awt.Color;

public class Block5ZB implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(0,50,25);
	private Color outlineColor = new Color(0,100,50);
	
	public Block5ZB()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5ZB", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5ZB", true);
		block[0][1] = b1;
		block[0][2] = b1;	//	-**
		block[1][1] = b2;	//  -*-
		block[2][0] = b1;	//  **-
		block[2][1] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}