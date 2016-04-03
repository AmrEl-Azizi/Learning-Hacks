package gameEntities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameGraphics.Animation;
import gameGraphics.AnimationController;
import gameGraphics.ImageLoader;
import gameInterface.Key;

public class Player {

	private int x, y;
	private BufferedImage p1, p2, p3, p4;
	private Key key;
	private int lastkey;
	private AnimationController ac;
	private ImageLoader loader;

	/*
	 * KEY
	 * 
	 * p1 = down p2 = up p3 = left p4 = right
	 * 
	 */

	public Player(int x, int y, ImageLoader loader, Key key) {
		this.x = x;
		this.y = y;
		p1 = loader.loadImage(Paths.p1);
		p2 = loader.loadImage(Paths.p2);
		p3 = loader.loadImage(Paths.p3);
		p4 = loader.loadImage(Paths.p4);
		this.lastkey = 1;
		this.key = key;
		this.loader = loader;
		loadAnimations();
	}

	private void loadAnimations() {
		ac = new AnimationController();

		Animation upAnim = new Animation(Paths.p2anim0, 64, 64, .05, loader);
		Animation downAnim = new Animation(Paths.p1anim0, 64, 64, 0.05, loader);
		Animation leftAnim = new Animation(Paths.p3anim0, 64, 64, .05, loader);
		Animation rightAnim = new Animation(Paths.p4anim0, 64, 64, .05, loader);

		upAnim.load();
		downAnim.load();
		leftAnim.load();
		rightAnim.load();

		BufferedImage array[] = { p1, p2, p3, p4 };

		ac.setStaticImages(array);
		ac.setStaticImageFromArray(0);

		ac.addAnimation(upAnim, "upAnim");
		ac.addAnimation(downAnim, "downAnim");
		ac.addAnimation(leftAnim, "leftAnim");
		ac.addAnimation(rightAnim, "rightAnim");

	}

	public void tick() {
	}

	public void render(Graphics g, boolean a) {
		if (a && key.isDown()) {
			ac.setAnimationActive("downAnim");
			lastkey = 1;
		} else if (a && key.isUp()) {
			ac.setAnimationActive("upAnim");
			lastkey = 2;
		} else if (a &&key.isLeft()) {
			ac.setAnimationActive("leftAnim");
			lastkey = 3;
		} else if (a && key.isRight()) {
			ac.setAnimationActive("rightAnim");
			lastkey = 4;
		} else {
			if (lastkey == 1) {
				ac.setStaticImageFromArray(0);
			} else if (lastkey == 2) {
				ac.setStaticImageFromArray(1);
			} else if (lastkey == 3) {
				ac.setStaticImageFromArray(2);
			} else {
				ac.setStaticImageFromArray(3);
			}
			ac.setStaticImageActive();
		}
		ac.render(g, x, y);
		// g.drawImage(p1, x, y, null);
	}

	public int getLastKey() {
		return this.lastkey;
	}
}
