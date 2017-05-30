import java.awt.Color;

public class BlockO implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][2];
	private Color fillColor = new Color(204,0,204);
	private Color outlineColor = new Color(255,51,255);
	
	public BlockO()
	{
		BlockSquare b1 = new BlockSquare(fillColor, outlineColor, "O", true);
		block[0][0] = b1;
		block[0][1] = b1;	//	**
		block[1][0] = b1;	//  **
		block[1][1] = b1;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
	
	public String getRotationType()
	{
		return "O";
	}
}