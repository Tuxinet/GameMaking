package me.tuxinet.Game2.Entity;

import me.tuxinet.Game2.input.keyboard;
import me.tuxinet.Game2.level.Level;
import me.tuxinet.Game2.screen.Screen;
import me.tuxinet.Game2.sprites.Sprite;

public class Player extends Mob {
	private int[] pixels;
	private int speed = 1;
	public final int SIZE;
	
	private int anim = 0;
	private int dir = 0;
	private int counter = 0;
	private int soundInt = 20;
	private boolean moving = false;
	private boolean flipped = false;
	
	private Sprite sprite = Sprite.playerdown0;
	private keyboard key;

	public Player(int x, int y, keyboard key, Level level) {
		this.SIZE = sprite.SIZE;
		this.x = x;
		this.y = y;
		this.key = key;
		pixels = new int[sprite.pixels.length];
		for (int i = 0; i < sprite.pixels.length; i++) {
			pixels[i] = sprite.pixels[i];
		}
	}

	public void update() {
		if (anim < 7500) {
			anim++;
		} else {
			anim = 0;
		}
		
		// Increasing the counter
		counter++;
		
		// Handling movement and setting the direction variables for animation
		int xa = 0, ya = 0;
		if (key.left) {
			xa -= speed;
			dir = 3;
		}
		if (key.right) {
			xa += speed;
			dir = 1;
		}
		if (key.up) {
			ya -= speed;
			dir = 0;
		}
		if (key.down) {
			ya += speed;
			dir = 2;
		}
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			moving = true;
		} else {
			moving = false;
		}
	}

	public void render(Screen screen) {
		flipped = false;
		if (!moving) {
			counter = soundInt - 1;
		}
		if (moving) {
			if (dir == 0) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerup1;
				} else {
					sprite = Sprite.playerup2;
				}
			}
			
			if (dir == 1) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerside1;
				} else {
					sprite = Sprite.playerside2;
				}
			}
			
			if (dir == 2) {
				if (anim % 20 > 10) {
					sprite = Sprite.playerdown1;
				} else {
					sprite = Sprite.playerdown2;
				}
			}
			
			if (dir == 3) {
				flipped = true;
				if (anim % 20 > 10) {
					sprite = Sprite.playerside1;
				} else {
					sprite = Sprite.playerside2;
				}
			}
			if (counter == soundInt) {
				level.getTile(x / 16, y / 16).play();
				System.out.println(x / 16 + " " + y / 16);
				counter = 0;
			}
		}
		
		if (!moving) {
			if (dir == 0) {
				sprite = Sprite.playerup0;
			}
			
			if (dir == 1) {
				sprite = Sprite.playerside0;
			}
			
			if (dir == 2) {
				sprite = Sprite.playerdown0;
			}
			
			if (dir == 3) {
				sprite = Sprite.playerside0;
				flipped = true;
			}
		}
		screen.renderPlayer(x - SIZE / 2, y - SIZE / 2, flipped, sprite);
	}
}
