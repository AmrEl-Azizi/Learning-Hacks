package gameEntities;

import java.awt.Graphics;
import java.util.ArrayList;

import gameFramework.DialogueController;
import gameGraphics.ImageLoader;
import gameInterface.Key;

public class EntityManager {

	private ArrayList<Entity> entities;
	private ArrayList<Entity> remove;
	private ArrayList<Entity> npc;
	private Key key;
	private int speed;
	public int globalX, globalY, xAdj, yAdj;
	private ImageLoader loader;
	private Player p;
	private DialogueController DiaCont;

	public EntityManager(Key key, int speed, ImageLoader loader, Player p, DialogueController DiaCont) {
		entities = new ArrayList<Entity>();
		remove = new ArrayList<Entity>();
		npc = new ArrayList<Entity>();
		this.key = key;
		this.speed = speed;
		this.loader = loader;
		globalX = 288;
		globalY = 288;
		xAdj = 12;
		yAdj = 26;
		this.p = p;
		this.DiaCont = DiaCont;
		init();
	}

	public void setDiaCont(DialogueController DiaCont) {
		this.DiaCont = DiaCont;
	}

	public void init() {
		addEntity(new NPC(64 * 2, 64 * 6, 0, loader, this, Paths.mother, "M", -1));
		addEntity(new NPC(-444, 172, 0, loader, this, Paths.female3, "S", 2));
		addEntity(new NPC(-316, 172, 0, loader, this, Paths.male1, "S", 2));
		addEntity(new NPC(-316, 300, 0, loader, this, Paths.male2, "DS", 2));
		addEntity(new NPC(-576 + 192, 64, 0, loader, this, Paths.teacher, "T", 1));
		addEntity(new NPC(-576 + 192 + 128, 64 - 480, 0, loader, this, Paths.cashier, "C", -1));
		addEntity(new NPC(0, 64, 0, loader, this, Paths.female2, "DRW", -1));
		addEntity(new NPC(64, 64, 0, loader, this, Paths.female1, "DRB", -1));
	}

	public ArrayList<Entity> getNpcList() {
		return this.npc;
	}

	public void tick() {
		moveMap();
		for (Entity e : entities) {
			e.tick();
		}
		for (Entity e : npc) {
			e.tick();
		}
		// System.out.println("X: " + globalX + " Y: " + globalY);
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		for (Entity e : npc) {
			e.render(g);
		}
	}

	public void lateTick() {
		for (Entity ee : remove) {
			entities.remove(ee);
			// remove.remove(ee);
		}
	}

	public void addEntity(Entity e) {
		if (e instanceof NPC) {
			npc.add(e);
		} else {
			entities.add(e);
		}
	}

	public void removeEntity(Entity e) {
		remove.add(e);
	}

	public void removeAllEntities() {
		for (Entity e : entities) {
			remove.add(e);
		}
	}

	private void moveMap() {
		if (DiaCont.lockKeys)
			return;
		if (key.isUp()) {
			if (checkCollisionY(1, yAdj)) {
				return;
			}
			moveEntities(0, 1);
		}
		if (key.isDown()) {
			if (checkCollisionY(-1, -yAdj)) {
				return;
			}
			moveEntities(0, -1);
		}
		if (key.isRight()) {
			if (checkCollisionX(1, -xAdj)) {
				return;
			}
			moveEntities(-1, 0);
		}
		if (key.isLeft()) {
			if (checkCollisionX(-1, xAdj)) {
				return;
			}
			moveEntities(1, 0);
		}
	}

	private void moveEntities(int x, int y) {
		x *= speed;
		y *= speed;
		for (Entity e : entities) {
			e.x += x;
			e.y += y;
		}
		for (Entity e : npc) {
			e.x += x;
			e.y += y;
		}
	}

	private boolean checkCollisionX(int x, int xAdj) {
		x = x * speed + globalX - xAdj;
		int y = globalY;
		int xDif = 0;
		int yDif = 0;
		Entity ee = null;
		for (Entity e : entities) {
			xDif = x - e.getX();
			yDif = e.getY() - y;
			if (xDif >= 0 && xDif <= 64 && yDif >= -64 && yDif <= 0) {
				ee = e;
				break;
			}
		}
		Entity n = null;
		if (ee.getWalkable()) {
			for (Entity e : npc) {
				xDif = x - e.getX();
				yDif = e.getY() - y;
				if (xDif >= 0 && xDif <= 64 && yDif >= -64 && yDif <= 0) {
					n = e;
					break;
				}
			}
			if (n != null)
				return true;
		}
		return !ee.getWalkable();
	}

	private boolean checkCollisionY(int y, int yAdj) {
		int x = globalX;
		y = y * speed + globalY - yAdj;
		int xDif = 0;
		int yDif = 0;
		Entity ee = null;
		for (Entity e : entities) {
			xDif = x - e.getX();
			yDif = e.getY() - y;
			if (xDif >= 0 && xDif <= 64 && yDif >= -64 && yDif <= 0) {
				ee = e;
				break;
			}
		}

		Entity n = null;
		if (ee.getWalkable()) {
			for (Entity e : npc) {
				xDif = x - e.getX();
				yDif = e.getY() - y;
				if (xDif >= 0 && xDif <= 64 && yDif >= -64 && yDif <= 0) {
					n = e;
					break;
				}
			}
			if (n != null)
				return true;
		}
		return !ee.getWalkable();
	}

	public Entity getNPC() {
		int x, y, xDif, yDif;
		if (p.getLastKey() == 1) {
			x = globalX;
			y = -1 * speed + globalY + yAdj;
		} else if (p.getLastKey() == 2) {
			x = globalX;
			y = 1 * speed + globalY - yAdj;
		} else if (p.getLastKey() == 3) {
			x = -1 * speed + globalX - xAdj;
			y = globalY;
		} else {
			x = 1 * speed + globalX + xAdj;
			y = globalY;
		}
		for (Entity e : npc) {
			xDif = x - e.getX();
			yDif = e.getY() - y;
			if (xDif >= 0 && xDif <= 64 && yDif >= -64 && yDif <= 0) {
				return e;
			}
		}
		return null;
	}

	public Entity getTile() {
		int x, y, xDif, yDif;
		if (p.getLastKey() == 1) {
			x = globalX;
			y = -1 * speed + globalY + yAdj;
		} else if (p.getLastKey() == 2) {
			x = globalX;
			y = 1 * speed + globalY - yAdj;
		} else if (p.getLastKey() == 3) {
			x = -1 * speed + globalX - xAdj;
			y = globalY;
		} else {
			x = 1 * speed + globalX + xAdj;
			y = globalY;
		}
		for (Entity e : entities) {
			xDif = x - e.getX();
			yDif = e.getY() - y;
			if (xDif >= 0 && xDif <= 64 && yDif >= -64 && yDif <= 0) {
				return e;
			}
		}
		return null;
	}
}