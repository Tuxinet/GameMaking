package me.tuxinet.Game2.level;

import java.util.Random;

import me.tuxinet.Game2.level.tile.Tile;
import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Level {

	public int[] tiles;
	public int w;
	public int h;

	public Sprite sprite;
	
	public static Level level = new Level("res/levels/spawn.png/");

	public Level(int w, int h) {
		this.w = w;
		this.h = h;
		tiles = new int[w * h];

		generateRandom();
	}
	
	public Level(String path) {
		MapLoader map = new MapLoader(path);
		tiles = new int[map.w * map.h];
		this.w = map.w;
		this.h = map.h;
		for (int i = 0; i < map.tiles.length; i++) {
			tiles[i] = map.tiles[i];
		}
		System.out.println(tiles[1]);
	}

	public void generateRandom() {
		Random random = new Random();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int randint = random.nextInt(2);
				tiles[x + y * w] = randint;

			}
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 3;
		int x1 = (xScroll + screen.width + 8) >> 3;
		int y0 = yScroll >> 3;
		int y1 = (yScroll + screen.height + 8) >> 3;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= w || y >= h) return Tile.voidTile;
		if (tiles[x + y * w] == Tile.grassCol) return Tile.grassTile;
		if (tiles[x + y * w] == Tile.pathCol) return Tile.stoneTile;
		return Tile.grassTile;
	}

	public void renderMap(Screen screen) {
		int width = screen.width;
		int height = screen.height;

		int[] mapPixels = new int[width * height];

		
	}

}
