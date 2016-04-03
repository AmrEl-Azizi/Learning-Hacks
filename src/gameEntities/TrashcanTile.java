package gameEntities;

import gameGraphics.ImageLoader;

public class TrashcanTile extends Entity{
    
    public TrashcanTile(int x, int y, int id, ImageLoader loader){
        super(x, y, id, loader, false);
        img = loader.loadImage(Paths.trashcanTile);
    }
    
}
