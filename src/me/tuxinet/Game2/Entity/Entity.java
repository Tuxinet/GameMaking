package me.tuxinet.Game2.Entity;

import java.util.Random;

import me.tuxinet.Game2.level.Level;
import me.tuxinet.Game2.screen.Screen;

public abstract class Entity {

	public int x;
	public int y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update() {
	}
	
	public void render(Screen screen) {
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}

}
