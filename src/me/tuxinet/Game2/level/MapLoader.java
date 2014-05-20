package me.tuxinet.Game2.level;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class MapLoader {
	
	public int[] tiles;
	
	public int w, h;
	
	public MapLoader(String path) {
		loadMap(path);
	}

	private void loadMap(String path) {
		try {
			BufferedImage map = ImageIO.read(MapLoader.class.getResource(path));
			w = map.getWidth();
			h = map.getHeight();
			tiles = new int[w * h];
			map.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
