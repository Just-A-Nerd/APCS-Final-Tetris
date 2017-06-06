import java.awt.Color;

public class Block5I implements Block
{
	private BlockSquare[][] block = new BlockSquare[1][5];
	private Color fillColor = new Color(100,50,0);
	private Color outlineColor = new Color(150,75,0);
	
	public Block5I()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "5I", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "5I", true);
		block[0][0] = b1;
		block[0][1] = b1;
		block[0][2] = b2;	//  *****
		block[0][3] = b1;
		block[0][4] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
}