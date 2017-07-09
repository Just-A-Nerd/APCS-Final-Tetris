
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;


public class Game
{
	private static Timer timer = new Timer();
	static boolean isPaused = false;
	private static boolean genBlock;
	private static boolean isFirstBlock = true;
	private static final int LEVEL1_SPEED = 1000;
	private static final int NEXT_LEVEL_SPEED_INC1 = 200;
	private static final int NEXT_LEVEL_SPEED_INC2 = 20;
	private static int currentSpeed = LEVEL1_SPEED;
	private static TimerTask task;
	
	public static void Update()
	{
		//put stuff here to make it run repeatedly without delay
	}
	
	public static void downLoop()
	{
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			public void run()
			{
				if(!isPaused && !KeyboardListener.isTitleScreen())
				{
					//if(isFirstBlock)
					//	PlayingField.makeBlockAppear();
					
					genBlock = false;
					if(PlayingField.doesHitBottom())
					{
						PlayingField.hitBottom();
						genBlock = true;
						
						int numLines = PlayingField.clearLines();
						PointCounter.addLinePoints(numLines);
						
						//PointCounter.setLevel(PointCounter.getLevel()+1);
						//changeTimer();
					}
					
					
					
					BlockManipulator.Move("down");
					
					if(genBlock)
						PlayingField.makeBlockAppear();
					
					//isFirstBlock = false;
					
					System.out.println(currentSpeed);
					
					
				}
			}
		}, currentSpeed, currentSpeed);
	}
	
	public static void changeTimer()
	{
		timer.cancel();
		if(PointCounter.getLevel() == 1)
			currentSpeed = LEVEL1_SPEED;
		else if(PointCounter.getLevel() <= 5)
			currentSpeed -= NEXT_LEVEL_SPEED_INC1;
		else if(PointCounter.getLevel() > 5 && PointCounter.getLevel() < 10)
			currentSpeed -= NEXT_LEVEL_SPEED_INC2;
		downLoop();
	}
	
	public static void Reset()
	{
		PlayingField.resetRandLists();
		PlayingField.setGameOver(false);
		PlayingField.resetArray();
		PointCounter.resetPointCounter();
		changeTimer();
		Flash.flashLoop();
	}
	
	public static void Pause()
	{
		isPaused = !isPaused;
	}
	public static boolean isPaused()
	{
		return isPaused;
	}
}