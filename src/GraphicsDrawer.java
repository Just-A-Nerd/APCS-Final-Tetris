import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

public class GraphicsDrawer
{
	private static final int PIXELS_OFF_EDGE = 50;
	private static final int BLOCK_SIZE = 40;
	private static final int BORDER_SIZE = 5;
	private static final String font = "Terminus Re33"; 
	
	public static void drawGraphics(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//Field
		g2.setPaint(new Color(0, 0 ,0 ));
		g2.fill(new Rectangle2D.Double(0,0,1000,1000));
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
		for(int row = PlayingField.getBuffer(); row < PlayingField.getField().length; row++)
		{
			for(int column = 0; column < PlayingField.getField()[0].length; column++)
			{
				if(PlayingField.getField()[row][column] != null)
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
		g2.draw(new Rectangle2D.Double(500, 50, 100, 100));//Level Display
		g2.draw(new Rectangle2D.Double(500, 200, 220, 180));//Next Block Display
		g2.draw(new Rectangle2D.Double(650, 50, 300, 100));//Score Display
		g2.draw(new Rectangle2D.Double(775, 250, 175, 100));//Lines Cleared Display
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(651,51,298,98));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font(font, 0, 36));
		g2.drawString("Score", 750, 45);
		g2.drawString(Integer.toString(PointCounter.getPoints()), 795 - (Integer.toString(PointCounter.getPoints()).length() * 7), 110);
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(501,51,98,98));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font(font, 0, 36));
		g2.drawString("Level", 510, 45);
		g2.drawString(Integer.toString(PointCounter.getLevel()), 550 - (Integer.toString(PointCounter.getLevel()).length() * 7), 110);
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(776,251,148,98));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font(font, 0, 36));
		g2.drawString("Lines Cleared", 740, 245);
		g2.drawString(Integer.toString(PointCounter.getLinesCleared()), 860 - (Integer.toString(PointCounter.getLinesCleared()).length() * 7), 310);
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(501,201,178,178));
		
		//draw the block in the next block display
		for(int row = 0; row < PlayingField.getNextBlock().getBlockArray().length; row++)
		{
			for(int column = 0; column < PlayingField.getNextBlock().getBlockArray()[0].length; column++)
			{
				if(PlayingField.getNextBlock().getBlockArray()[row][column] != null)
				{
					g2.setPaint(PlayingField.getNextBlock().getBlockArray()[row][column].getOutlineColor());
					g2.fill(new Rectangle2D.Double(
							(500+10 + column * BLOCK_SIZE), 
							(200+10 + row * BLOCK_SIZE), 
							(BLOCK_SIZE), 
							(BLOCK_SIZE)));
					//Fills center of shape
					g2.setPaint(PlayingField.getNextBlock().getBlockArray()[row][column].getFillColor());
					g2.fill(new Rectangle2D.Double(
							(500+10 + column * BLOCK_SIZE + BORDER_SIZE), 
							(200+10 + row * BLOCK_SIZE + BORDER_SIZE), 
							(BLOCK_SIZE - BORDER_SIZE * 2), 
							(BLOCK_SIZE - BORDER_SIZE * 2)));
				}
				g2.setPaint(new Color(0,0,0));
			}
		}
	}
	
	public static void drawGameOver(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//g2.setPaint(new Color(50,50,50));
		//g2.fill(new Rectangle2D.Double(0,0,1000,1000));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font("Terminus Re33", 0, 80));
		g2.drawString("Game Over", 75, 400);
		g2.setFont(new Font("Terminus Re33", 0, 40));
		g2.drawString("Press Enter to Restart", 500, 500);
	}
	
	public static void drawTitleScreen(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint(new Color(50,50,50));
		g2.fill(new Rectangle2D.Double(0,0,1000,1000));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font("Terminus Re33", 0, 80));
		g2.drawString("Tetris/Pentris", 190, 400);
		g2.setFont(new Font("Terminus Re33", 0, 40));
		g2.drawString("Press Enter to Start", 270, 500);
		
		g2.setFont(new Font("Terminus Re33", 0, 40));
		g2.drawString("Controls", 100, 610);
		g2.setFont(new Font("Terminus Re33", 0, 25));
		g2.drawString("Lateral Movement = arrow keys", 30, 650);
		g2.drawString("Spin Right = Z", 70, 680);
		g2.drawString("Spin Left = X", 70, 710);
		g2.drawString("Pause = P", 90, 740);
		
		g2.setFont(new Font("Terminus Re33", 0, 30));
		g2.drawString("Press 1 for Tetriminoes and Pentiminoes", 350, 710);
		g2.drawString("Press 2 for Tetriminoes only", 350, 760);
		g2.drawString("Press 3 for Pentiminoes only", 350, 810);
	}
}
