package me.tuxinet.Game2.screen;

import java.util.Random;

import me.tuxinet.Game2.level.tile.Tile;
import me.tuxinet.Game2.sprites.Sprite;

public class Screen {
	public int width;
	public int height;
	private int xOffset = 0;
	private int yOffset = 0;
	public int[] pixels;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void postProcess(int num) {
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			pixels[random.nextInt(width) + random.nextInt(height) * width] = random.nextInt(0xffffff);
		}
	}

	public void renderQuad(int x, int y, int size, int colour) {
		for (int yy = 0; yy < size; yy++) {
			for (int xx = 0; xx < size; xx++) {
				if (xx + x < 0) continue;
				if (xx + x >= width) continue;
				if (yy + y < 0) continue;
				if (yy + y >= height) continue;

				int xPos = xx + x;
				int yPos = yy + y;

				pixels[xPos + yPos * width] = colour;
			}
		}
	}

	public void clearScreen() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderPlayer(int xx, int yy, Sprite sprite) {
		for (int y = 0; y < sprite.SIZE; y++) {
			for (int x = 0; x < sprite.SIZE; x++) {
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col == 0xffff00ff) continue;
				pixels[(xx + x) + (yy + y) * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
