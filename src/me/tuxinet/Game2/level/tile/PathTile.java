package me.tuxinet.Game2.level.tile;

import java.util.Random;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sound.MusicPlayer;
import me.tuxinet.Game2.sprites.Sprite;

public class PathTile extends Tile {
	
	private Random random = new Random();
	
	public PathTile(Sprite sprite, int mod) {
		super(sprite, mod);
	}
	
	public void play() {
		int i = random.nextInt(4);
		
		if (i == 0) {
			System.out.println(i);
			MusicPlayer.gravelSound1.play(0);
		}
		
		if (i == 1) {
			System.out.println(i);
			MusicPlayer.gravelSound2.play(0);
		}
		
		if (i == 2) {
			System.out.println(i);
			MusicPlayer.gravelSound3.play(0);
		}
		
		if (i == 3) {
			System.out.println(i);
			MusicPlayer.gravelSound4.play(0);
		}
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << mod, y << mod, this);
	}
	
	public boolean solid() {
		return false;
	}

}
