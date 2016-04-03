package gameEntities;

import gameGraphics.ImageLoader;

public class MailboxTile extends Entity{
    
    public MailboxTile(int x, int y, int id, ImageLoader loader){
        super(x, y, id, loader, false);
        img = loader.loadImage(Paths.mailboxTile);
    }
    
}
