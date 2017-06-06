import java.awt.Color;

public class BlockL implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(150,20,20);
	private Color outlineColor = new Color(200,20,20);
	
	public BlockL()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "L", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "L", true);
		block[0][0] = b1;
		block[0][1] = b2;	//	***
		block[0][2] = b1;	//  *--
		block[1][0] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}