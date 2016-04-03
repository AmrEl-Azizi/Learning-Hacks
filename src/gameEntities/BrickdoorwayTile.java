package gameEntities;

import gameGraphics.ImageLoader;

public class BrickdoorwayTile extends Entity{

	public BrickdoorwayTile(int x, int y, int id, ImageLoader loader) {
		super(x, y, id, loader, true);
		img = loader.loadImage(Paths.brickdoorwayTile);
	}

}
