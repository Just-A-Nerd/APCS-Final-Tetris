import java.awt.Color;

public class Block5T implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(80,80,0);
	private Color outlineColor = new Color(100,100,0);
	
	public Block5T()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5T", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5T", true);
		block[0][0] = b1;
		block[0][1] = b1;	//	***
		block[0][2] = b1;	//  -*-
		block[1][1] = b2;	//  -*-
		block[2][1] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}