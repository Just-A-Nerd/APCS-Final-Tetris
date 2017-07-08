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
	private static final int BLOCK_SIZE = 48;
	private static final int BORDER_SIZE = 5;
	private static final String font = "Sans Serif"; 
	private static final int LEFT_PIXELS = 450;
	
	public static void drawGraphics(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		//Field
		g2.setPaint(new Color(0, 0 ,0 ));
		g2.fill(new Rectangle2D.Double(0,0,1920,1080));
		g2.fill(new Rectangle2D.Double(PIXELS_OFF_EDGE, PIXELS_OFF_EDGE, PlayingField.getField()[0].length * BLOCK_SIZE, (PlayingField.getField().length - 2) * BLOCK_SIZE));
		//Border of Field
		g2.setPaint(new Color(255, 255, 255));
		g2.drawLine(PIXELS_OFF_EDGE + LEFT_PIXELS - 1, 
				PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE + LEFT_PIXELS - 1, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE);
		g2.drawLine(PIXELS_OFF_EDGE + LEFT_PIXELS, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE, 
				PIXELS_OFF_EDGE + (PlayingField.getField()[0].length) * BLOCK_SIZE + LEFT_PIXELS, 
				PIXELS_OFF_EDGE + (PlayingField.getField().length - PlayingField.getBuffer()) * BLOCK_SIZE);
		g2.drawLine(PIXELS_OFF_EDGE + (PlayingField.getField()[0].length) * BLOCK_SIZE + LEFT_PIXELS, 
				PIXELS_OFF_EDGE, 
				PIXELS_OFF_EDGE + (PlayingField.getField()[0].length) * BLOCK_SIZE + LEFT_PIXELS, 
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
							(PIXELS_OFF_EDGE + LEFT_PIXELS + column * BLOCK_SIZE), 
							(PIXELS_OFF_EDGE + (row - PlayingField.getBuffer()) * BLOCK_SIZE), 
							(BLOCK_SIZE), 
							(BLOCK_SIZE)));
					//Fills center of shape
					g2.setPaint(PlayingField.getField()[row][column].getFillColor());
					g2.fill(new Rectangle2D.Double(
							(PIXELS_OFF_EDGE + LEFT_PIXELS + column * BLOCK_SIZE + BORDER_SIZE), 
							(PIXELS_OFF_EDGE + (row - PlayingField.getBuffer()) * BLOCK_SIZE + BORDER_SIZE), 
							(BLOCK_SIZE - BORDER_SIZE * 2), 
							(BLOCK_SIZE - BORDER_SIZE * 2)));
				}
				g2.setPaint(new Color(0,0,0));
			}
		}
		g2.setPaint(new Color(255,255,255));
		g2.draw(new Rectangle2D.Double(1000, 50, 100, 100));//Level Display
		g2.draw(new Rectangle2D.Double(1000, 200, 260, 180));//Next Block Display
		g2.draw(new Rectangle2D.Double(1150, 50, 300, 100));//Score Display
		g2.draw(new Rectangle2D.Double(1315, 250, 175, 100));//Lines Cleared Display
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(1151,51,298,98));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font(font, 0, 36));
		g2.drawString("Score", 1250, 45);
		g2.drawString(Integer.toString(PointCounter.getPoints()), 1295 - (Integer.toString(PointCounter.getPoints()).length() * 7), 110);
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(1001,51,98,98));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font(font, 0, 36));
		g2.drawString("Level", 1000, 45);
		g2.drawString(Integer.toString(PointCounter.getLevel()), 1050 - (Integer.toString(PointCounter.getLevel()).length() * 7), 110);
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(1316,251,148,98));
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font(font, 0, 36));
		g2.drawString("Lines Cleared", 1280, 245);
		g2.drawString(Integer.toString(PointCounter.getLinesCleared()), 1400 - (Integer.toString(PointCounter.getLinesCleared()).length() * 7), 310);
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(1001,201,178,178));
		
		//draw the block in the next block display
		for(int row = 0; row < PlayingField.getNextBlock().getBlockArray().length; row++)
		{
			for(int column = 0; column < PlayingField.getNextBlock().getBlockArray()[0].length; column++)
			{
				if(PlayingField.getNextBlock().getBlockArray()[row][column] != null)
				{
					g2.setPaint(PlayingField.getNextBlock().getBlockArray()[row][column].getOutlineColor());
					g2.fill(new Rectangle2D.Double(
							(1000+10 + column * BLOCK_SIZE), 
							(200+10 + row * BLOCK_SIZE), 
							(BLOCK_SIZE), 
							(BLOCK_SIZE)));
					//Fills center of shape
					g2.setPaint(PlayingField.getNextBlock().getBlockArray()[row][column].getFillColor());
					g2.fill(new Rectangle2D.Double(
							(1000+10 + column * BLOCK_SIZE + BORDER_SIZE), 
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
		g2.setFont(new Font("Sans Serif", 0, 80));
		g2.drawString("Game Over", 1040, 475);
		g2.setFont(new Font("Sans Serif", 0, 40));
		g2.drawString("Press UP to Restart", 1085, 550);
	}
	
	public static void drawTitleScreen(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint(new Color(0,0,0));
		g2.fill(new Rectangle2D.Double(0,0,1920,1080));
		
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font("Sans Serif", 0, 80));
		g2.drawString("Tetris/Pentris", 660, 400);
		
		if(Flash.getState())
		{
			g2.setFont(new Font("Sans Serif", 0, 40));
			g2.drawString("Press A to Start", 760, 500);
		}
		
		g2.setFont(new Font("Sans Serif", 0, 35));
		g2.drawString("Andrew Hollabaugh & Justin Neria", 650, 950);
		
		/*g2.setFont(new Font("Terminus Re33", 0, 40));
		g2.drawString("Controls", 100, 610);
		g2.setFont(new Font("Terminus Re33", 0, 25));
		g2.drawString("Lateral Movement = arrow keys", 30, 650);
		g2.drawString("Spin Right = Z", 70, 680);
		g2.drawString("Spin Left = X", 70, 710);
		g2.drawString("Pause = P", 90, 740);*/
		
		g2.setFont(new Font("Sans Serif", 0, 30));
		g2.drawString("Tetrominoes only", 725, 710);
		g2.drawString("Pentominoes only", 725, 760);
		g2.drawString("Tetrominoes and Pentominoes", 725, 810);
		
		g2.setPaint(new Color(255,255,255));
		if(PlayingField.getGameType() == 1)
			g2.fill(new Rectangle2D.Double(700,695,15,15));
		else if(PlayingField.getGameType() == 2)
			g2.fill(new Rectangle2D.Double(700,745,15,15));
		else if(PlayingField.getGameType() == 3)
			g2.fill(new Rectangle2D.Double(700,795,15,15));
	}
	
	public static void drawPauseGraphics(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setPaint(new Color(255,255,255));
		g2.setFont(new Font("Sans Serif", 0, 80));
		g2.drawString("Paused", 600, 450);
	}
	
}
