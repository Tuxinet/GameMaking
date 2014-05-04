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

	public Level(int w, int h) {
		this.w = w;
		this.h = h;
		tiles = new int[w * h];

		generateRandom();
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
		if (tiles[x + y * w] == 0) return Tile.grassTile;
		if (tiles[x + y * w] == 1) return Tile.stoneTile;
		return Tile.voidTile;
	}

	public void renderMap(Screen screen) {
		int width = screen.width;
		int height = screen.height;

		int[] mapPixels = new int[width * height];

		
	}

}
