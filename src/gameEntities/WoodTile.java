package gameEntities;

import gameGraphics.ImageLoader;

public class WoodTile extends Entity{
    
    public WoodTile(int x, int y, int id, ImageLoader loader) {
        super(x, y, id, loader, true);
        img = loader.loadImage(Paths.woodTile);
    }
    
}
