import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame
{

	
	public Window()
	{
		//JLabel jlbHelloWorld = new JLabel("test");
		//add(jlbHelloWorld);
		this.setSize(1000, 1000);
		KeyListener listener = new KeyboardListener();
		addKeyListener(listener);
		setFocusable(true);
		setVisible(true);
		setBackground(new Color(0,0,0));
	}
	
	public void paint(Graphics g)
	{
		GraphicsDrawer.drawGraphics(g);
	}
	
}