package gameEntities;

import gameGraphics.ImageLoader;

public class TreeTile extends Entity{
    
    public TreeTile(int x, int y, int id, ImageLoader loader){
        super(x, y, id, loader, false);
        img = loader.loadImage(Paths.treeTile);
    }
    
}
