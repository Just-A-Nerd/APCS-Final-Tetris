import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener
{
	private final String moveLeftKey = "Left";
	private final String moveRightKey = "Right";
	private final String moveDownKey = "Down";
	private final String spinLeftKey = "X";
	private final String spinRightKey = "Z";
	private final String pauseKey = "P";
	private final String startKey = "Enter";
	private static boolean isTitleScreen = true;
	
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		
		if(!Game.isPaused)
		{
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
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(startKey))
			{
				if(PlayingField.isGameOver())
				{
					isTitleScreen = true;
					Game.Reset();
				}
				else
					isTitleScreen = false;
			}
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(pauseKey))
			Game.Pause();
	}
		
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	public static boolean isTitleScreen()
	{
		return isTitleScreen;
	}
}