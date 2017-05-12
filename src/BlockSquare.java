import java.awt.Color;

public class BlockSquare
{
	private Color fillColor;
	private Color outlineColor;
	private String name;
	
	public BlockSquare(Color fc, Color oc, String n)
	{
		fillColor = fc;
		outlineColor = oc;
		n = name;
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
}
