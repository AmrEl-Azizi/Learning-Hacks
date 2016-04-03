package gameEntities;

import gameGraphics.ImageLoader;

public class StoneTile extends Entity {

	public StoneTile(int x, int y, int id, ImageLoader loader) {
		super(x, y, id, loader, true);
		img = loader.loadImage(Paths.stoneTile);
	}

}
