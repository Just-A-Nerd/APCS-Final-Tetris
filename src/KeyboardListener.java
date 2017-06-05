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
	private final String modeSelect1 = "1";
	private final String modeSelect2 = "2";
	private final String modeSelect3 = "3";
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
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(pauseKey) && !isTitleScreen)
			Game.Pause();
		
		if(isTitleScreen && KeyEvent.getKeyText(e.getKeyCode()).equals(modeSelect1))
			PlayingField.setGameType(1);
		if(isTitleScreen && KeyEvent.getKeyText(e.getKeyCode()).equals(modeSelect2))
			PlayingField.setGameType(2);
		if(isTitleScreen && KeyEvent.getKeyText(e.getKeyCode()).equals(modeSelect3))
			PlayingField.setGameType(3);
	}
		
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	public static boolean isTitleScreen()
	{
		return isTitleScreen;
	}
}