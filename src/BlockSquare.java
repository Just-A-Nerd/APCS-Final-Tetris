import java.awt.Color;

public class BlockSquare
{
	private Color fillColor;
	private Color outlineColor;
	
	public BlockSquare(Color fc, Color oc)
	{
		fillColor = fc;
		outlineColor = oc;
	}
	
	public Color getFillColor()
	{
		return fillColor;
	}
	
	public Color getOutlineColor()
	{
		return outlineColor;
	}
}
