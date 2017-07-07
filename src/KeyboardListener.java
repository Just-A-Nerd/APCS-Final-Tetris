import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener
{
	private final String moveLeftKey = "Left";
	private final String moveRightKey = "Right";
	private final String moveUpKey = "Up";
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
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveUpKey))
			{
				if(isTitleScreen)
				{
					PlayingField.setGameType(PlayingField.getGameType() - 1);
				}
			}
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(moveDownKey))
			{
				if(isTitleScreen)
				{
					PlayingField.setGameType(PlayingField.getGameType() + 1);
				}
				else
					BlockManipulator.Move("down");
			}
				
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(spinLeftKey))
				BlockManipulator.Spin("left");
				
			if(KeyEvent.getKeyText(e.getKeyCode()).equals(spinRightKey))
			{
				if(isTitleScreen)
				{
					isTitleScreen = false;
					PlayingField.makeBlockAppear();
					Flash.cancelTimer();
				}
				else if(PlayingField.isGameOver())
				{
					isTitleScreen = true;
					Game.Reset();
				}
				else
					BlockManipulator.Spin("right");
			}
			
			if(KeyEvent.getKeyText(e.getKeyCode()).equals("G"))
			{
				if(!isTitleScreen)
					PlayingField.setGameOver(true);
			}

			
			/*if(KeyEvent.getKeyText(e.getKeyCode()).equals(startKey))
			{
				if(PlayingField.isGameOver())
				{
					isTitleScreen = true;
					Game.Reset();
				}
				else
				{
					isTitleScreen = false;
					PlayingField.makeBlockAppear();
					Flash.cancelTimer();
				}
			}*/
		}
		if(KeyEvent.getKeyText(e.getKeyCode()).equals(pauseKey) && !isTitleScreen)
			Game.Pause();
		
		/*if(isTitleScreen && KeyEvent.getKeyText(e.getKeyCode()).equals(modeSelect1))
		{
			PlayingField.setGameType(1);
			Sound.BLIP.play();
		}
		if(isTitleScreen && KeyEvent.getKeyText(e.getKeyCode()).equals(modeSelect2))
		{
			PlayingField.setGameType(2);
			Sound.BLIP.play();
		}
		if(isTitleScreen && KeyEvent.getKeyText(e.getKeyCode()).equals(modeSelect3))
		{
			PlayingField.setGameType(3);
			Sound.BLIP.play();
		}*/
	}
		
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	
	public static boolean isTitleScreen()
	{
		return isTitleScreen;
	}
}