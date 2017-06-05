import java.awt.Color;

public class Block5U implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(100,100,255);
	private Color outlineColor = new Color(150,150,255);
	
	public Block5U()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5U", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5U", true);
		block[0][0] = b1;
		block[0][2] = b1;	//	*-*
		block[1][0] = b1;	//  ***
		block[1][1] = b2;
		block[1][2] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}