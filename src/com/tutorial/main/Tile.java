package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class Tile extends GameObject{

	private Color color;
	
	public Tile(int x, int y, ID id) {
		super(x, y, id);
		int rand = (int) (Math.random() * 4);
		if(rand == 0 || rand == 1 || rand == 2) color = Color.green;
		if(rand == 3) color = Color.gray;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 20, 20);
	}	
	
}
