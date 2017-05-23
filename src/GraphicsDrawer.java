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
		g2.setPaint(new Color(0, 0 ,0 ));
		g2.fill(new Rectangle2D.Double(50, 50, PlayingField.getField()[0].length * blockSize, PlayingField.getField().length * blockSize));
		g2.setPaint(new Color(255, 255, 255));
		g2.drawLine(50, 50, 50 , 50 + PlayingField.getField().length * (blockSize - 2));
		g2.drawLine(50, 50 + PlayingField.getField().length * (blockSize - 2), 50 + PlayingField.getField()[0].length * blockSize , 50 + PlayingField.getField().length * (blockSize - 2));

		g2.drawLine(50 + PlayingField.getField()[0].length * blockSize, 50, 50 + PlayingField.getField()[0].length * blockSize,  50 + PlayingField.getField().length * (blockSize - 2));
		BlockSquare[][] field = PlayingField.getField();
		
		g2.setPaint(new Color(0,0,0));
		g2.draw(new Rectangle2D.Double(850, 200, 100, 100));//Next Block Display
		g2.draw(new Rectangle2D.Double(650, 50, 300, 100));//Score Display
		g2.drawString("Score", 775, 100);
		
		for(int i = PlayingField.getBuffer(); i < PlayingField.getField().length; i++)
		{
			for(int j = 0; j < PlayingField.getField()[0].length; j++)
			{
				g2.setPaint(PlayingField.getField()[i][j].getOutlineColor());
				g2.fill(new Rectangle2D.Double(blockSize,blockSize,i*blockSize,j*blockSize));
			}
		}
	}
}
