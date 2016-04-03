package gameEngine;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import gameInterface.Key;

public class Engine extends Canvas implements Runnable {
	private static final long serialVersionUID = -902284247852811313L;
	
	private boolean running = false;
	private Thread gameThread;
	private BufferedImage blank;
	private Game game;
	private Key key;
	
	public Engine(Dimension d) {
		blank = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
	}

	public void init() {
		key = new Key();
		addKeyListener(key);
		game = new Game(key);
		requestFocus();
	}
	
	public void startGame(){
		start();
	}
	
	public void stopGame(){
		running = false;
	}
	
	private synchronized void start(){
		if(running)
			return;
		running = true;
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	private synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public void tick() {
		game.tick();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(blank, 0, 0, getWidth(), getHeight(), null);
		game.render(g);
		g.dispose();
		bs.show();
	}

	public void lateTick(){
		game.lateTick();
	}
	
	@Override
	public void run() {
		init();
		game.init();
		long lasttime = System.nanoTime();
		final double numberOfTicks = 60.0;
		double ns = 1000000000 / numberOfTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		int lateticks = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lasttime) / ns;
			lasttime = now;
			if (delta >= 1) {
				tick();
				ticks++;
				render();
				frames++;
				lateTick();
				lateticks++;
				delta--;
			}
			// here for no sync
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("Ticks: " + ticks + " Frames: " + frames + " Late Ticks: " + lateticks);
				ticks = 0;
				frames = 0;
				lateticks = 0;
			}
		}
		stop();
	}

}
