package gameEntities;

import gameGraphics.ImageLoader;

public class ShelfTile extends Entity{

	public ShelfTile(int x, int y, int id, ImageLoader loader) {
		super(x, y, id, loader, false);
		img = loader.loadImage(Paths.shelfTile);
	}

}
