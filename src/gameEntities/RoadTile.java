package gameEntities;

import gameGraphics.ImageLoader;

public class RoadTile extends Entity{

	public RoadTile(int x, int y, int id, ImageLoader loader, int image) {
		super(x, y, id, loader, true);
		img = loader.loadImage(Paths.intersectionTileprefix + image + ".png");
	}

	
	
}
