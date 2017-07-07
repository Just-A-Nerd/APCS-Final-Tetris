import java.awt.Color;

public class BlockSquare
{
	private Color fillColor;
	private Color outlineColor;
	private String name;
	private boolean axisOfRotation;
	private int blockPos = 0;
	
	public BlockSquare(Color fc, Color oc, String n, boolean a)
	{
		fillColor = fc;
		outlineColor = oc;
		name = n;
		axisOfRotation = a;
	}
	
	public Color getFillColor()
	{
		return fillColor;
	}
	
	public Color getOutlineColor()
	{
		return outlineColor;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public boolean isAxisOfRotation()
	{
		return axisOfRotation;
	}
	
	public void setAxisOfRotation(boolean b)
	{
		axisOfRotation = b;
	}
	
	public int getBlockPos()
	{
		return blockPos;
	}
	
	public void setBlockPos()
	{
		if(blockPos == 0)
			blockPos = 1;
		else
			blockPos = 0;
	}
}
