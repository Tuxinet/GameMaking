package me.tuxinet.Game2.level;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MapLoader {
	
	public int[] tiles;
	private String path;
	
	public int w, h;
	
	public MapLoader(String path) {
		this.path = path;
		loadMap(path);
	}

	private void loadMap(String path) {
		try {
			BufferedImage map = ImageIO.read(new File(path));
			w = map.getWidth();
			h = map.getHeight();
			tiles = new int[w * h];
			map.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
