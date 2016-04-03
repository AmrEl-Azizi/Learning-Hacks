package gameGraphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private BufferedImage images[];
	private String path;
	private ImageLoader loader;
	private int sizeOfEachImageX , sizeOfEachImageY;
	private double counter;
	private double speedOfAnimation;
	private boolean nulled = true;
	
	private boolean seperateFiles = false;
	private String paths[];

	public Animation(String spriteSheetPath, int sizeOfEachImage, double speedOfAnimation, ImageLoader loader) {
		this.path = spriteSheetPath;
		this.sizeOfEachImageX = sizeOfEachImage;
		this.sizeOfEachImageY = sizeOfEachImage;
		this.speedOfAnimation = speedOfAnimation;
		this.loader = loader;
		counter = 0;
	}
	
	public Animation(String spriteSheetPath, int sizeOfEachImageX, int sizeOfEachImageY, double speedOfAnimation, ImageLoader loader) {
		this.path = spriteSheetPath;
		this.sizeOfEachImageX = sizeOfEachImageX;
		this.sizeOfEachImageY = sizeOfEachImageY;
		this.speedOfAnimation = speedOfAnimation;
		this.loader = loader;
		counter = 0;
	}
	
	public Animation(String[] imagePaths, int sizeOfEachImageX, int sizeOfEachImageY, double speedOfAnimation, ImageLoader loader) {//for seperate files
		this.paths = imagePaths;
		this.sizeOfEachImageX = sizeOfEachImageX;
		this.sizeOfEachImageY = sizeOfEachImageY;
		this.speedOfAnimation = speedOfAnimation;
		this.loader = loader;
		seperateFiles = true;
		counter = 0;
	}
	
	public boolean load(){
		if(!seperateFiles){
			BufferedImage sprite = loader.loadImage(path);
			if(sprite == null){
				System.err.println("Unable to load " + path);
				nulled = true;
				return false;
			}
			int rows = (sprite.getWidth() / sizeOfEachImageX);
			int cols = (sprite.getHeight() / sizeOfEachImageY);
			images = new BufferedImage[rows*cols];
			for(int x = 0; x < rows; x++){
				for(int y = 0; y < cols; y++){
					images[x+y] = sprite.getSubimage(x*sizeOfEachImageX, y*sizeOfEachImageY, sizeOfEachImageX, sizeOfEachImageY);
				}
			}
			System.out.println("Loaded sprite - " + path);
			nulled = false;
			return true;
		}else{
			int rows = paths.length;
			int cols = 1;
			BufferedImage tempImg;
			images = new BufferedImage[rows*cols];
			int i = 0;
			for(int x = 0; x < rows; x++){
				for(int y = 0; y < cols; y++){
					tempImg = loader.loadImage(paths[i]);
					if(tempImg == null){
						System.err.println("Unable to load " + path);
						nulled = true;
						return false;
					}
					i++;
					images[x+y] = tempImg;
				}
			}
			System.out.println("Loaded sprite - " + paths[0]);
			nulled = false;
			return true;
		}
	}
	
	public void render(Graphics g, int x, int y){
		if(!nulled){
			if(counter >= images.length)//or its images.length-1
				counter = 0;
			g.drawImage(images[(int)counter], x, y, null);
			counter+= speedOfAnimation;
		}
	}
	
	public void render(Graphics g, int x, int y, int width, int height){
		if(!nulled){
			if(counter >= images.length-1)
				counter = 0;
			g.drawImage(images[(int)counter], x, y, width, height, null);
			counter+= speedOfAnimation;
		}
	}
	
}
