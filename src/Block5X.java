import java.awt.Color;

public class Block5X implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(50,50,50);
	private Color outlineColor = new Color(100,100,100);
	
	public Block5X()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5X", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5X", true);
		block[0][1] = b1;
		block[1][0] = b1;	//	-*-
		block[1][1] = b2;	//  ***
		block[1][2] = b1;	//  -*-
		block[2][1] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}