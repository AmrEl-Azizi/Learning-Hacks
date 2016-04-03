package gameEntities;

import gameGraphics.ImageLoader;

public class CashregisterTile extends Entity{

	public CashregisterTile(int x, int y, int id, ImageLoader loader) {
		super(x, y, id, loader, false);
		img = loader.loadImage(Paths.cashregisterTile);
	}

}
