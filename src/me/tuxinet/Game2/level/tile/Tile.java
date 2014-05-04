package me.tuxinet.Game2.level.tile;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Tile {
	
	public static Tile grassTile = new GrassTile(Sprite.grassSprite);
	public static Tile voidTile = new GrassTile(Sprite.voidSprite);
	public static Tile stoneTile = new StoneTile(Sprite.stoneSprite);
	
	public Sprite sprite;
	
	private boolean solid = false;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return solid;
	}

}
