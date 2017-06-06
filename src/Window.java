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
			GraphicsDrawer.drawGraphics(g);
		
		if(PlayingField.isGameOver())
			GraphicsDrawer.drawGameOver(g);
		
		if(KeyboardListener.isTitleScreen())
			GraphicsDrawer.drawTitleScreen(g);
	}
	
    /*public void actionPerformed(ActionEvent e)
    {
    	setVisible(true);
    }

    public void windowClosing(WindowEvent e)
    {
    	dispose();
    	System.exit(0);
    }*/
    
    public static void main(String[] args)
    {
    	JFrame frame = new JFrame("Tetris");
		Window window = new Window();
		frame.add(window);
		frame.setSize(1000,1000);
		frame.setFocusable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0,0,0));
		KeyListener listener = new KeyboardListener();
		frame.addKeyListener(listener);
		Game.downLoop();
		//PlayingField.makeBlockAppear();
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