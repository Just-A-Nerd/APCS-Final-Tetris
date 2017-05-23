import java.awt.Color;

public class BlockS implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(100,100,100);
	private Color outlineColor = new Color(150,100,100);
	
	public BlockS()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "S", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "S", true);
		block[0][1] = b2;
		block[0][2] = b1;	//	-**
		block[1][0] = b1;	//  **-
		block[1][1] = b1;
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