import java.awt.Color;

public class Block5W implements Block
{
	private BlockSquare[][] block = new BlockSquare[3][3];
	private Color fillColor = new Color(50,200,175);
	private Color outlineColor = new Color(30,220,200);
	
	public Block5W()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5W", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5W", true);
		block[0][0] = b1;
		block[1][0] = b1;	//	*--
		block[1][1] = b2;	//  **-
		block[2][1] = b1;	//  -**
		block[2][2] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}