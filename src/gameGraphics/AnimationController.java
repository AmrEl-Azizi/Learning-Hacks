package gameGraphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationController {

	private ArrayList<Animation> animations;
	private ArrayList<String> ids;
	private int active;
	private Animation activeAnimation;
	private BufferedImage staticImage;
	private BufferedImage staticImages[];
	
	public AnimationController() {
		animations = new ArrayList<Animation>();
		ids = new ArrayList<String>();
		active = 1;
	}
	
	public void addAnimation(Animation animation, String id){
		animations.add(animation);
		ids.add(id);
	}
	
	public boolean removeAnimation(String id){
		if(ids.indexOf(id) == -1){
			System.err.println("Unable to remove animation Check ID - AnimationController");
			return false;
		}
		int index = ids.indexOf(id);
		ids.remove(index);
		animations.remove(index);
		return true;
	}
	
	public void setStaticImage(BufferedImage img){
		staticImage = img;
	}
	
	public void setStaticImages(BufferedImage img[]){
		staticImages = img;
	}
	
	public void setStaticImageFromArray(int index){
		staticImage = staticImages[index];
	}
	
	public void setStaticImageActive(){
		active = 0;
	}
	
	public void setAnimationActive(String id){
		if(ids.indexOf(id) == -1){
			System.err.println("Unable to set active animation Check ID - AnimationController");
		}
		if(animations.get(ids.indexOf(id)) == activeAnimation && active != 0){
			return;
		}
		int index = ids.indexOf(id);
		active = index+1;//so active wont be 0
		activeAnimation = animations.get(index);
	}
	
	public String getAnimationActive(){
		return ids.get(active);
	}
	
	public void render(Graphics g, int x, int y){
		if(active == 0 && staticImage != null){
			g.drawImage(staticImage, x, y, null);
		}else if(active == 0 && staticImage == null){
			if(animations.size() == 0){
				return;
			}else{
				active = 1;
			}
		}else{
			if(activeAnimation == null){
				return;//NOT LOADED
			}
			activeAnimation.render(g, x, y);
		}
	}
	
	public void render(Graphics g, int x, int y, int width, int height){
		if(active == 0 && staticImage != null){
			g.drawImage(staticImage, x, y, width, height, null);
		}else if(active == 0 && staticImage == null){
			if(animations.size() == 0){
				return;
			}else{
				active = 1;
			}
		}else{
			if(activeAnimation == null){
				return;//NOT LOADED
			}
			activeAnimation.render(g, x, y, width, height);
		}
	}
	
}
