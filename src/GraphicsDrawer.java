import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class GraphicsDrawer
{
	private static final int PIXELS_OFF_EDGE = 50;
	private static final int BLOCK_SIZE = 40;
	private static final int BORDER_SIZE = 5;
	public static void drawGraphics(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;
		//Field
		g2.setPaint(new Color(0, 0 ,0 ));
		g2.fill(new Rectangle2D.Double(50, 50, PlayingField.getField()[0].length * BLOCK_SIZE, (PlayingField.getField().length - 2) * BLOCK_SIZE));
		//Border of Field
		g2.setPaint(new Color(255, 0, 0));
		g2.drawLine(PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE);
		g2.drawLine(PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE, 
				PIXELS_OFF_EDGE + (PlayingField.getField()[0].length) * BLOCK_SIZE, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE);
		g2.drawLine(PIXELS_OFF_EDGE + (PlayingField.getField()[0].length) * BLOCK_SIZE, 
				PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE + (PlayingField.getField()[0].length) * BLOCK_SIZE, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE);
		//Drawing Tetriminoes Drawing 
		for(int row = 2; row < PlayingField.getField().length - PlayingField.getBuffer(); row++)
		{
			for(int column = 0; column < PlayingField.getField()[0].length; column++)
			{
				g2.setPaint(PlayingField.getField()[row][column].getOutlineColor());
				g2.fill(new Rectangle2D.Double(PIXELS_OFF_EDGE + (column * BLOCK_SIZE), 
						PIXELS_OFF_EDGE + (row * column), 
						PIXELS_OFF_EDGE + (column + 1) * BLOCK_SIZE, 
						PIXELS_OFF_EDGE + (row + 1) * BLOCK_SIZE));
				g2.setPaint(PlayingField.getField()[row][column].getFillColor());
				g2.fill(new Rectangle2D.Double(PIXELS_OFF_EDGE + ((column * BLOCK_SIZE) + BORDER_SIZE), 
						PIXELS_OFF_EDGE + (row * BLOCK_SIZE + BORDER_SIZE), 
						PIXELS_OFF_EDGE + ((column + 1) * BLOCK_SIZE - BORDER_SIZE), 
						PIXELS_OFF_EDGE + ((row + 1) * BLOCK_SIZE - BORDER_SIZE)));
				
			}
		}
		
		
		
		
		g2.setPaint(new Color(0,0,0));
		g2.draw(new Rectangle2D.Double(850, 200, 100, 100));//Next Block Display
		g2.draw(new Rectangle2D.Double(650, 50, 300, 100));//Score Display
		g2.drawString("Score", 775, 100);
		
		
		
		
	}
}
