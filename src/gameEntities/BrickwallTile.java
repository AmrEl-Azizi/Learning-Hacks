package gameEntities;

import gameGraphics.ImageLoader;

public class BrickwallTile extends Entity{
    
    public BrickwallTile(int x, int y, int id, ImageLoader loader, int image) {
        super(x, y, id, loader, false);
        img = loader.loadImage(Paths.brickwallTileprefix + image + ".png");
    }
    
}