import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame implements ActionListener, KeyListener
{
	public Window()
	{
		//JLabel jlbHelloWorld = new JLabel("test");
		//add(jlbHelloWorld);
		Game game = new Game();
		this.setSize(1000, 1000);
		//KeyListener listener = new KeyboardListener();
		addKeyListener();
		//listener.addActionListener(this);
		setFocusable(true);
		setVisible(true);
		setBackground(new Color(0,0,0));
	}
	
	public void paint(Graphics g)
	{
		GraphicsDrawer.drawGraphics(g);
	}
	
    public void actionPerformed(ActionEvent e)
    {
    	setVisible(true);
    }

    public void windowClosing(WindowEvent e)
    {
    	dispose();
    	System.exit(0);
    }
    
    public void windowOpened(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    
    private final String moveLeftKey = "Left";
	private final String moveRightKey = "Right";
	private final String moveDownKey = "Down";
	private final String spinLeftKey = "X";
	private final String spinRightKey = "Z";
	
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveLeftKey))
		{
			BlockManipulator.Move("left");
			setVisible(true);
		}
        
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveRightKey))
			BlockManipulator.Move("right");
			
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveDownKey))
			BlockManipulator.Move("down");
			
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(spinLeftKey))
			BlockManipulator.Spin("left");
			
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(spinRightKey))
			BlockManipulator.Spin("right");
	}
		
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	public static void main(String[] args)
	{
		
	}
}