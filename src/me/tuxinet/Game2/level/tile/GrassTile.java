package me.tuxinet.Game2.level.tile;

import java.util.Random;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sound.MusicPlayer;
import me.tuxinet.Game2.sprites.Sprite;

public class GrassTile extends Tile {

	Random random = new Random();

	public GrassTile(Sprite sprite, int mod) {
		super(sprite, mod);
	}

	public void play() {
		int i = random.nextInt(4);

		if (i == 0) {
			MusicPlayer.grassSound1.play(0);
		}

		if (i == 1) {
			MusicPlayer.grassSound2.play(0);
		}

		if (i == 2) {
			MusicPlayer.grassSound3.play(0);
		}

		if (i == 3) {
			MusicPlayer.grassSound4.play(0);
		}
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << mod, y << mod, this);
	}

}
