package com.tutorial.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Map{

	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private GameObject player;
	private int x, y;
	
	public Map(int x, int y){
		this.x = x;
		this.y = y;
		for(int i = 0, z = 0, t = 0; i < 2304; i++){
			tiles.add(new Tile(z, t, ID.Tile));
			z += 20;
			if(z == 1280){
				z = 0; 
				t += 20;
			}		
		}
	}
	
	public void moveLeft(){
		x -= 20;
	}
	
	public void moveRight(){
		y += 20;
	}

	public ArrayList<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	
	public void render(Graphics g){
		for(int i = 0; i < tiles.size(); i++){
			tiles.get(i).setX(tiles.get(i).getX() + x);
			tiles.get(i).setY(tiles.get(i).getY() + y);
			tiles.get(i).render(g);
		}
	}

	public void tick() {
		
	}
	
	public void updatePlayer(GameObject player){
		this.player = player;
	}
	
}
