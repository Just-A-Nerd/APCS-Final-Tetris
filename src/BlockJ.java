import java.awt.Color;

public class BlockJ implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(0,100,20);
	private Color outlineColor = new Color(0,150,20);
	
	public BlockJ()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "J", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "J", true);
		block[0][0] = b1;
		block[0][1] = b2;	//	***
		block[0][2] = b1;	//  --*
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