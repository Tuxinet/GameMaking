package me.tuxinet.Game2.level;

import me.tuxinet.Game2.level.tile.Tile;
import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Level {

	public int[] tiles;
	public int w;
	public int h;

	public Sprite sprite;

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
	}

	public void generateRandom() {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
			}
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 32) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 32) >> 4;
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

}
