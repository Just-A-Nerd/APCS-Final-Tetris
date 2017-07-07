import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JPanel
{
	boolean gameOverSound = false;
	boolean backgroundSound = false;

	public Window()
	{
		//JLabel jlbHelloWorld = new JLabel("test");
		//add(jlbHelloWorld);	
		//this.setSize(1000, 1000);
		//KeyListener listener = new KeyboardListener();
		//addKeyListener(listener);
		//listener.addActionListener(this);
		//setFocusable(true);
		//setVisible(true);
		//setBackground(new Color(0,0,0));
	}
	
	public void paint(Graphics g)
	{
		if(!(PlayingField.isGameOver()) && !(KeyboardListener.isTitleScreen()))
		{
			if(!backgroundSound) {
				Sound.BACKGROUND.loop();
				backgroundSound = true;
			}
			GraphicsDrawer.drawGraphics(g);
		}
		if(PlayingField.isGameOver())
		{
			GraphicsDrawer.drawGameOver(g);
			Sound.BACKGROUND.stop();
			backgroundSound = false;
			if (!gameOverSound) {
				gameOverSound = true;
				
				Sound.GAMEOVER.play();
			}
		}
		if(KeyboardListener.isTitleScreen())
		{
			gameOverSound = false;
			GraphicsDrawer.drawTitleScreen(g);
		}
		if(Game.isPaused())
		{
			GraphicsDrawer.drawPauseGraphics(g);
		}
	}
	
    
    public static void main(String[] args)
    {
    	JFrame frame = new JFrame("Tetris");
		Window window = new Window();
		frame.add(window);
		frame.setSize(1000,1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0,0,0));
		KeyListener listener = new KeyboardListener();
		frame.addKeyListener(listener);
		Game.downLoop();
		Flash.flashLoop();

		while(true)
		{
			//Game.Update();
			window.repaint();
			try
			{
				Thread.sleep(30);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}