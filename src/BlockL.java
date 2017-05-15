import java.awt.Color;

public class BlockL implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(100,100,100);
	private Color outlineColor = new Color(150,100,100);
	
	public BlockL()
	{
		BlockSquare b = new BlockSquare(fillColor, outlineColor, "L");
		block[0][0] = b;
		block[0][1] = b;	//	***
		block[0][2] = b;	//  *--
		block[1][0] = b;
	}
	
	public BlockSquare[][] getBlockArray()
	{
		return block;
	}
	
	public int[] getAxisOfRotation()
	{
		int[] a = {0,1};
		return a;
	}
}