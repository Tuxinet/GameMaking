package me.tuxinet.Game2.level.tile;

import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Tile {
	
	public static Tile grassTile = new GrassTile(Sprite.grassSprite, 4);
	public static Tile voidTile = new GrassTile(Sprite.voidSprite, 4);
	public static Tile stoneTile = new PathTile(Sprite.stoneSprite, 4);
	
	public static int grassCol = 0x00ff00;
	public static int pathCol = 0xff646464;
	public int mod; 
	
	public Sprite sprite;
	
	private boolean solid = false;
	
	public Tile(Sprite sprite, int mod) {
		this.sprite = sprite;
		this.mod = mod;
	}
	
	public void play() {
	}
	
	public void render(int x, int y, Screen screen) {
	}
	
	public boolean solid() {
		return solid;
	}

}
