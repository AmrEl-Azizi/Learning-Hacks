package gameEngine;

import java.awt.Graphics;

import gameAudio.AudioPlayer;
import gameEntities.EntityManager;
import gameEntities.Player;
import gameFramework.Story;
import gameGraphics.ImageLoader;
import gameGraphics.MapLoader;
import gameInterface.Key;

public class Game {

	private EntityManager em;
	private Player p;
	private Key key;
	public Story story;
	
	public Game(Key key) {
		this.key = key;
	}
	
	public void init(){
		ImageLoader loader = new ImageLoader();

		
		AudioPlayer audio = new AudioPlayer("/Music/Mighty_Like_Us.wav");
		audio.loop(10000);
		p = new Player(256, 256, loader, key);
		em = new EntityManager(key, 2, loader, p, null);
		story = new Story(key, loader, em);
		em.setDiaCont(story.getDiaCont());
		MapLoader map = new MapLoader("Maps/", em, loader);
		map.loadMap("map0=0");
		map.loadMap("map-1=0");
		map.loadMap("map-1=-1");
		map.loadMap("map0=-1");
		map.loadMap("map0=1");
		map.loadMap("map-1=1");
		map.loadMap("map1=0");
		map.loadMap("map1=1");
		map.loadMap("map1=-1");
		map.loadMap("map-1=-2");
		map.loadMap("map-2=-1");
		map.loadMap("map-2=0");
		map.loadMap("map-2=1");
		map.loadMap("map0=-2");
		
	}
	
	public void tick(){
		story.tick();
		em.tick();
		p.tick();
	}
	
	
	public void render(Graphics g){
		em.render(g);
		story.render(g);
		if(story.getDiaCont().lockKeys)
			p.render(g, false);
		else 
			p.render(g, true);
	}
	
	public void lateTick(){
		em.lateTick();
	}
	
}
