import java.awt.Color;

public class BlockO implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][2];
	private Color fillColor = new Color(100,100,100);
	private Color outlineColor = new Color(150,100,100);
	
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