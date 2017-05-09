<<<<<<< HEAD
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JPanel {
	
	public Window() {
		KeyListener listener = new KeyboardListener();
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
		Window keyboardExample = new Window();
		frame.add(keyboardExample);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
=======
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
	}
	
	public void paint(Graphics g)
	{
		GraphicsDrawer.drawGraphics(g);
	}
	
>>>>>>> 890522908e9e6e9410f799e27f1fff2ae4d48d49
}