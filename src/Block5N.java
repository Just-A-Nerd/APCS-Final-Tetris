import java.awt.Color;

public class Block5N implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][4];
	private Color fillColor = new Color(200,200,200);
	private Color outlineColor = new Color(255,255,255);
	
	public Block5N()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5N", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5N", true);
		block[0][0] = b1;
		block[0][1] = b2;	//	***-
		block[0][2] = b2;	//  --**
		block[1][2] = b2;
		block[1][3] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}