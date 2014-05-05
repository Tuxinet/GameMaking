package me.tuxinet.Game2.player;

import me.tuxinet.Game2.input.keyboard;
import me.tuxinet.Game2.level.Level;
import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Player extends Mob {
	private int[] pixels;
	private final int SIZE;
	
	private Sprite sprite = Sprite.playerSprite;
	private keyboard key;

	public Player(int x, int y, keyboard key, Level level) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.SIZE = sprite.SIZE;
		pixels = new int[sprite.pixels.length];
		for (int i = 0; i < sprite.pixels.length; i++) {
			pixels[i] = sprite.pixels[i];
		}
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if (key.up) ya--;
		if (key.down) ya++;
		if (key.left) xa--;
		if (key.right) xa++;
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
		}
	}
	


	public void render(Screen screen) {
		sprite = Sprite.playerSprite;
		screen.renderPlayer(x, y, sprite);
	}

}
