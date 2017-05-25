import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

class Game
{
	public static void main(String[] args) throws IOException, InvalidMidiDataException, MidiUnavailableException
	{
		
		new Window();
		update();
		
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		InputStream is = new BufferedInputStream(new FileInputStream(new File("TETRISB.mid")));
		sequencer.setSequence(is);
		sequencer.start();
	}
	public static void update()
	{
		PlayingField.makeBlockAppear();
	}
}
