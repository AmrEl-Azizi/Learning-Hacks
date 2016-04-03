package gameEntities;

import gameGraphics.ImageLoader;

public class FlowerTile1 extends Entity{
    
    public FlowerTile1(int x, int y, int id, ImageLoader loader){
        super(x, y, id, loader, true);
        img = loader.loadImage(Paths.flowerTile1);
    }
    
}
