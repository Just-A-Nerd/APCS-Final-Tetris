import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener
{
	private final String moveLeftKey = "Left";
	private final String moveRightKey = "Right";
	private final String moveDownKey = "Down";
	private final String spinLeftKey = "X";
	private final String spinRightKey = "Z";
	
		public void keyPressed(KeyEvent e)
		{
			//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveLeftKey))
				BlockManipulator.Move("left");
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveRightKey))
				BlockManipulator.Move("right");
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveDownKey))
				BlockManipulator.Move("down");
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(spinLeftKey))
				BlockManipulator.Spin("left");
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(spinRightKey))
				BlockManipulator.Spin("right");
		}
		
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
}