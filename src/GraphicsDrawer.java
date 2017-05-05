import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class GraphicsDrawer
{
	public static void drawGraphics(Graphics g)
	{
		int blockSize = 40;
		int borderSize = 5;
	    Graphics2D g2 = (Graphics2D) g;
	    BlockSquare redBlock = new BlockSquare(new Color(255,0,0), new Color(200,0,0));
	    g2.setPaint(redBlock.getOutlineColor());
	    g2.fill(new Rectangle2D.Double(50,50,blockSize,blockSize));
	    g2.setPaint(redBlock.getFillColor());
	    g2.fill(new Rectangle2D.Double(50+borderSize,50+borderSize,blockSize-borderSize*2,blockSize-borderSize*2));
	}
}
