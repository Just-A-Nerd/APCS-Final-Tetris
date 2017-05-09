import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
			{
				System.out.println("HI");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	}