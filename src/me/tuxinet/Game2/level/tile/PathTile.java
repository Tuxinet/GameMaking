package me.tuxinet.Game2.level.tile;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class PathTile extends Tile {

	public PathTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 3, y << 3, this);
	}
	
	public boolean solid() {
		return false;
	}

}