package gameEntities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameGraphics.ImageLoader;

public abstract class Entity {

	protected int x, y, id;
	protected BufferedImage img;
	protected boolean walkable;
	
	public Entity(int x, int y, int id, ImageLoader loader, boolean walkable) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.walkable = walkable;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(img, x, y, null);
	}
	
	public void lateTick(){
		
	}
	
	public int getID(){
		return id;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean getWalkable()
	{
		return this.walkable;
	}
}
