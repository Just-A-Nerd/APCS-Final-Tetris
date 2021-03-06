import java.awt.Color;

public class BlockI implements Block
{
	private BlockSquare[][] block = new BlockSquare[1][4];
	private Color fillColor = new Color(100,100,100);
	private Color outlineColor = new Color(150,100,100);
	
	public BlockI()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "I", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "I", true);
		block[0][0] = b1;
		block[0][1] = b2;
		block[0][2] = b2;	//  ****
		block[0][3] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
	
	public String getRotationType()
	{
		return "4x4";
	}
}