package me.tuxinet.Game2.player;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Player {
	private int[] pixels;
	private final int SIZE;
	
	private Sprite sprite;

	public Player(Sprite sprite) {
		this.SIZE = sprite.SIZE;
		pixels = new int[sprite.pixels.length];
		for (int i = 0; i < sprite.pixels.length; i++) {
			pixels[i] = sprite.pixels[i];
		}
	}

	public void render(int xx, int yy, Screen screen) {
		sprite = Sprite.playerSprite;
		screen.renderPlayer(xx - 4, yy - 4, sprite);
	}

}
