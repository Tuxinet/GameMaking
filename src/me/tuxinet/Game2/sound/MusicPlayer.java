package me.tuxinet.Game2.sound;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import javazoom.jlgui.basicplayer.BasicPlayer;

public class MusicPlayer {
	private String filepath ;
	private boolean ogg;
	
	private Clip clip;
	private BasicPlayer player;
	AudioInputStream ais;
	
	
	public static MusicPlayer grassSound1 = new MusicPlayer("/sounds/tiles/grass1.wav", false);
	public static MusicPlayer grassSound2 = new MusicPlayer("/sounds/tiles/grass2.wav", false);
	public static MusicPlayer grassSound3 = new MusicPlayer("/sounds/tiles/grass3.wav", false);
	public static MusicPlayer grassSound4 = new MusicPlayer("/sounds/tiles/grass4.wav", false);
	
	public static MusicPlayer gravelSound1 = new MusicPlayer("/sounds/tiles/gravel1.wav", false);
	public static MusicPlayer gravelSound2 = new MusicPlayer("/sounds/tiles/gravel2.wav", false);
	public static MusicPlayer gravelSound3 = new MusicPlayer("/sounds/tiles/gravel3.wav", false);
	public static MusicPlayer gravelSound4 = new MusicPlayer("/sounds/tiles/gravel4.wav", false);
	
	
	
	public MusicPlayer(String filepath, boolean ogg) {
		this.ogg = ogg;
		this.filepath = filepath;
	}
	
	public MusicPlayer() {
	}
	
	public void prepareAudio() {
		try {
			URL url = MusicPlayer.class.getResource(filepath);
			ais = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(ais);

			clip.addLineListener(new LineListener() {
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						event.getLine().close();
					}
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadOgg() {
		try {
			player = new BasicPlayer();
			player.open(new File(MusicPlayer.class.getResource(filepath).toURI()));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void play(int reps) {
		try {
			if (!ogg) {
				prepareAudio();
				clip.start();
			}
			
			if (ogg) {
				player.play();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}