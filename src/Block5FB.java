import java.awt.Color;

public class Block5FB implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(255,100,100);
	private Color outlineColor = new Color(255,150,150);
	
	public Block5FB()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5FB", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5FB", true);
		block[0][0] = b1;
		block[0][1] = b1;	//	**-
		block[1][1] = b2;	//  -**
		block[1][2] = b1;	//  -*-
		block[2][1] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}