package gameEntities;

import gameGraphics.ImageLoader;

public class GrassTile extends Entity{

	//private AnimationController ac;
	
	public GrassTile(int x, int y, int id, ImageLoader loader) {
		super(x, y, id, loader, true);
		img = loader.loadImage(Paths.grassTile);
		//ac = new AnimationController();
		//Animation test = new Animation("/Animations/grassAnimation.png", 64, 0.05, loader);
		//test.load();
		//ac.addAnimation(test, "test");
		//ac.setAnimationActive("test");
	}
	
	/*public void render(Graphics g){
		ac.render(g, x, y);
	}*/
	
}
