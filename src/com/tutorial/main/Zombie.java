package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class Zombie extends GameObject{

	public Zombie(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 32, 32);
	}
	
}
