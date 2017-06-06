import java.awt.Color;

public class Block5Z implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(0,255,0);
	private Color outlineColor = new Color(150,255,150);
	
	public Block5Z()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5Z", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5Z", true);
		block[0][0] = b1;
		block[0][1] = b1;	//	**-
		block[1][1] = b2;	//  -*-
		block[2][1] = b1;	//  -**
		block[2][2] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}