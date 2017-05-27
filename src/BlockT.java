import java.awt.Color;

public class BlockT implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(200,80,0);
	private Color outlineColor = new Color(255,100,0);
	
	public BlockT()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "T", false);
		BlockSquare b2 = new BlockSquare(fillColor, outlineColor, "T", true);
		block[0][0] = b1;
		block[0][1] = b2;	//	***
		block[0][2] = b1;	//  -*-
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