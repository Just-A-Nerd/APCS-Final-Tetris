import java.awt.Color;

public class Block5PB implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(0,150,0);
	private Color outlineColor = new Color(0,200,0);
	
	public Block5PB()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5PB", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5PB", true);
		block[0][1] = b1;
		block[0][2] = b1;	//	-**
		block[1][0] = b1;	//  ***
		block[1][1] = b2;
		block[1][2] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}