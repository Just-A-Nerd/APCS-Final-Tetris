import java.awt.Color;

public class BlockL implements Block
{
	private BlockSquare[][] block = new BlockSquare[2][3];
	private Color fillColor = new Color(100,100,100);
	private Color outlineColor = new Color(150,100,100);
	private int maxLength = 3;
	private int maxHeight = 2;
	
	public BlockL()
	{
		BlockSquare b = new BlockSquare(fillColor, outlineColor);
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
		int[] a = new int[2];
		int x = 0; //to be figured out later
		int y = 0;
		a[0] = x;
		a[1] = y;
		return a;
	}
	
	public int getMaxLength()
	{
		return maxLength;
	}
	
	public int getMaxHeight()
	{
		return maxHeight;
	}
}