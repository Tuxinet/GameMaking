package me.tuxinet.Game2.sprites;

import java.util.Random;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	static Random random = new Random();
	
	public static Sprite voidSprite = new Sprite(8, 0x1B87E0);	
	public static Sprite grassSprite = new Sprite(8, 0, 0, SpriteSheet.textures);
	public static Sprite stoneSprite = new Sprite(8, 1, 0, SpriteSheet.textures);
	public static Sprite playerSprite = new Sprite(8, 0, 7, SpriteSheet.textures);
	//public static Sprite voidSprite = new Sprite(16, random.nextInt(0xffffff));
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int colour) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = colour;
		}
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				if (sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE] == 0xFF00FF) break;
				else pixels[x + y * SIZE] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}

}
