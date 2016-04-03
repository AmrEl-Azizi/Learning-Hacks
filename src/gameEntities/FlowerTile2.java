package gameEntities;

import gameGraphics.ImageLoader;

public class FlowerTile2 extends Entity{
    
    public FlowerTile2(int x, int y, int id, ImageLoader loader){
        super(x, y, id, loader, true);
        img = loader.loadImage(Paths.flowerTile2);
    }
    
}
