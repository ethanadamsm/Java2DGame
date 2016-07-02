package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{

	private int width, height;
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		width = 32;
		height = 32;
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
