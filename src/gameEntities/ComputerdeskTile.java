package gameEntities;

import gameGraphics.ImageLoader;

public class ComputerdeskTile extends Entity{
    
    public ComputerdeskTile(int x, int y, int id, ImageLoader loader, int image){
        super(x, y, id, loader, false);
        img = loader.loadImage(Paths.computerdeskTileprefix + image + ".png");
    }
    
}
