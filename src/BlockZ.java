import java.awt.Color;

public class BlockZ implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(150,150,0);
	private Color outlineColor = new Color(200,200,0);
	
	public BlockZ()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "Z", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "Z", true);
		block[0][0] = b1;
		block[0][1] = b2;	//	**-
		block[1][1] = b1;	//  -**
		block[1][2] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
	
	public String getRotationType()
	{
		return "3x3";
	}
}