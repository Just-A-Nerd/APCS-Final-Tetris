import java.awt.Color;

public class Block5P implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(102,0,104);
	private Color outlineColor = new Color(140,30,180);
	
	public Block5P()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5P", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5P", true);
		block[0][0] = b1;
		block[0][1] = b2;	//	***
		block[0][2] = b1;	//  -**
		block[1][1] = b1;
		block[1][2] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}