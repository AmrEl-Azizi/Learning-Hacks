package gameEntities;

import gameGraphics.ImageLoader;

public class BrickcornerTile extends Entity{

	public BrickcornerTile(int x, int y, int id, ImageLoader loader, int image) {
		super(x, y, id, loader, false);
		img = loader.loadImage(Paths.brickcornerTileprefix + image + ".png");
	}

}
