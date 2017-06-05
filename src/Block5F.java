import java.awt.Color;

public class Block5F implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(100,100,100);
	private Color outlineColor = new Color(150,150,150);
	
	public Block5F()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5F", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5F", true);
		block[0][1] = b1;
		block[0][2] = b1;	//	-**
		block[1][0] = b1;	//  **-
		block[1][1] = b2;	//  -*-
		block[2][1] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}