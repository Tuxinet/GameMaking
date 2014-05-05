package me.tuxinet.Game2;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import me.tuxinet.Game2.input.keyboard;
import me.tuxinet.Game2.level.Level;
import me.tuxinet.Game2.player.Player;
import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
		
	private boolean running = false;
	public static int width = 100;
	public static int height = width / 16 * 9;
	public static int scale = 9;
	public static String title = "Test Game";
	
	public static Level level;
	
	private Player player;
	
	private Thread thread;
	private JFrame frame;
	private keyboard key;
	
	public static Screen screen;
	
	private int offsetX = 0;
	private int offsetY = 0;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		
		frame = new JFrame();
		screen = new Screen(width, height);
		key = new keyboard();
		level = level.level;
		player = new Player(0, 0, key, level);
		
		addKeyListener(key);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 30;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				ticks++;
				delta = 0;
			}
			render();
			frames++ ;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer = System.currentTimeMillis();
				System.out.println(ticks + " ups, " + frames + "fps");
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
		
		int offsetX = player.x - screen.width / 2;
		int offsetY = player.y - screen.height / 2;

		level.render(offsetX, offsetY, screen);
		player.render(screen);
		level.renderMap(screen);
		
		for (int i = 0; i < screen.pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		bs.show();
	}

	private void tick() {
		key.update();
		player.update();
		
		if (key.up) offsetY--;
		if (key.down) offsetY++;
		if (key.left) offsetX--;
		if (key.right) offsetX++;
		
		if (key.regen) level.generateRandom();
	}

	public static void main(String[] args) {
		Game game = new Game();
		
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.frame.setTitle(title);
		
		game.start();
	}

}
