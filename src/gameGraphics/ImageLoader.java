package gameGraphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	private BufferedImage img;
	
	public BufferedImage loadImage(String path){
		try {
			img = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			System.err.println("Unable to load " + path);
			e.printStackTrace();
			return null;
		}
		return img;
	}
	
}
