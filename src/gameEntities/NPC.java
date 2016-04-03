package gameEntities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gameGraphics.ImageLoader;

public class NPC extends Entity {

	private EntityManager em;
	private BufferedImage n1, n2, n3, n4, n;
	private String identifier;
	private int rotate;

	public NPC(int x, int y, int id, ImageLoader loader, EntityManager em, String prefixpath, String identifier,
			int rotate) {
		super(x, y, id, loader, false);
		this.em = em;
		n1 = loader.loadImage(prefixpath + "1.png");
		n2 = loader.loadImage(prefixpath + "2.png");
		n3 = loader.loadImage(prefixpath + "3.png");
		n4 = loader.loadImage(prefixpath + "4.png");
		if (rotate == 1)
			n = n1;
		else if (rotate == 2)
			n = n2;
		else if (rotate == 3)
			n = n3;
		else if (rotate == 4)
			n = n4;
		this.identifier = identifier;
		this.rotate = rotate;
	}

	public void setRotate(int x) {
		this.rotate = x;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void render(Graphics g) {
		if (rotate == -1) {
			if (Math.abs(em.globalX - x) > 128 || Math.abs(em.globalY - y) > 128) {
				n = n1;
			} else if (em.globalX <= x + 128 && em.globalX >= x + 64) {
				n = n4;
			} else if (em.globalX >= x - 128 && em.globalX <= x) {
				n = n3;
			} else if (em.globalY <= y) {
				n = n2;
			} else {
				n = n1;
			}
		}
		g.drawImage(n, x, y, null);
	}

}
