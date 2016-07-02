package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1550691097823471818L;

	public static final int WIDTH = 1280, HEIGHT = 720;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Hello", this, new KeyInput(handler));
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
		handler.addObject(new Zombie(WIDTH/2 - 64, HEIGHT/2-32, ID.Zombie));
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
			}
			if(System.currentTimeMillis() - timer > 1000){	
				timer += 1000;
			}	
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]){
		new Game();
	}
	
}
