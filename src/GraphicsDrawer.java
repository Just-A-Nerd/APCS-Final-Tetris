import java.awt.Color;
import java.awt.Font;
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
		g2.fill(new Rectangle2D.Double(PIXELS_OFF_EDGE, PIXELS_OFF_EDGE, PlayingField.getField()[0].length * BLOCK_SIZE, (PlayingField.getField().length - 2) * BLOCK_SIZE));
		//Border of Field
		g2.setPaint(new Color(255, 255, 255));
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
		//Drawing Tetriminoes 
		for(int row = 0; row < PlayingField.getField().length; row++)
		{
			for(int column = 0; column < PlayingField.getField()[0].length; column++)
			{
				if(PlayingField.getField()[row][column] == null) 
				{
					
				}
				else 
				{
					g2.setPaint(PlayingField.getField()[row][column].getOutlineColor());
					g2.fill(new Rectangle2D.Double(
							(PIXELS_OFF_EDGE + column * BLOCK_SIZE), 
							(PIXELS_OFF_EDGE + (row - PlayingField.getBuffer()) * BLOCK_SIZE), 
							(BLOCK_SIZE), 
							(BLOCK_SIZE)));
					//Fills center of shape
					g2.setPaint(PlayingField.getField()[row][column].getFillColor());
					g2.fill(new Rectangle2D.Double(
							(PIXELS_OFF_EDGE + column * BLOCK_SIZE + BORDER_SIZE), 
							(PIXELS_OFF_EDGE + (row - PlayingField.getBuffer()) * BLOCK_SIZE + BORDER_SIZE), 
							(BLOCK_SIZE - BORDER_SIZE * 2), 
							(BLOCK_SIZE - BORDER_SIZE * 2)));
					}
				g2.setPaint(new Color(0,0,0));
				}
			}
		
		
		
		
		g2.setPaint(new Color(255,255,255));
		g2.draw(new Rectangle2D.Double(850, 200, 100, 100));//Next Block Display
		g2.draw(new Rectangle2D.Double(650, 50, 300, 100));//Score Display
		g2.setFont(new Font("Sans Serif", 0, 36));
		g2.drawString(Integer.toString(PointCounter.getPoints()), 795 - (Integer.toString(PointCounter.getPoints()).length() * 7), 110);
		
		
		
		
	}
}
