import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip BACKGROUND = Applet.newAudioClip(Sound.class.getResource("TETRISB.MID"));
	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));

}
