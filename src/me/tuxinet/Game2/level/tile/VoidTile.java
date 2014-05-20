package me.tuxinet.Game2.level.tile;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite, int mod) {
		super(sprite, mod);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << mod, y << mod, this);
	}

}
