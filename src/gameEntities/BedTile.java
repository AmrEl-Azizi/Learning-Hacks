package gameEntities;

import gameGraphics.ImageLoader;

public class BedTile extends Entity{

	public BedTile(int x, int y, int id, ImageLoader loader) {
		super(x, y, id, loader, true);
		img = loader.loadImage(Paths.bedTile);
	}

}
