package gameGraphics;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import gameEntities.BedTile;
import gameEntities.BrickcornerTile;
import gameEntities.BrickdoorwayTile;
import gameEntities.BrickwallTile;
import gameEntities.CashregisterTile;
import gameEntities.ComputerdeskTile;
import gameEntities.EntityManager;
import gameEntities.FlowerTile1;
import gameEntities.FlowerTile2;
import gameEntities.GrassTile;
import gameEntities.MailboxTile;
import gameEntities.RoadTile;
import gameEntities.ShelfTile;
import gameEntities.StoneTile;
import gameEntities.TrashcanTile;
import gameEntities.TreeTile;
import gameEntities.WoodTile;

public class MapLoader {

	private String prefixPath;
	private final int mapSize = 11;
	private EntityManager em;
	private ImageLoader loader;
	
	public MapLoader(String pathToMaps, EntityManager em, ImageLoader loader) {
		prefixPath = pathToMaps;
		this.loader = loader;
		this.em = em;
	}
	
	public void loadMap(String map){
		String str = map.substring(3, map.length());
		String array[] = str.split("=");
		int locX = Integer.parseInt(array[0]);
		int locY = Integer.parseInt(array[1]);
		int[][] positions = processFile(map);
		for(int i = 0; i < positions.length; i++){
			for(int k = 0; k < positions[i].length; k++){
				if(positions[i][k] == 1){
					em.addEntity(new GrassTile((k*64) + (locX*576), (i*64) + (locY*576), 1, loader));
				}else if(positions[i][k] == 2){
					em.addEntity(new TreeTile((k*64) + (locX*576), (i*64) + (locY*576), 2, loader));
				}else if(positions[i][k] == 3){
					em.addEntity(new FlowerTile1((k*64) + (locX*576), (i*64) + (locY*576), 3, loader));
				}else if(positions[i][k] == 4){
					em.addEntity(new StoneTile((k*64) + (locX*576), (i*64) + (locY*576), 4, loader));
				}else if(positions[i][k] == 5){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 5, loader, 0));
				}else if(positions[i][k] == 6){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 6, loader, 1));
				}else if(positions[i][k] == 7){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 7, loader, 2));
				}else if(positions[i][k] == 8){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 8, loader, 3));
				}else if(positions[i][k] == 9){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 9, loader, 4));
				}else if(positions[i][k] == 10){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 10, loader, 5));
				}else if(positions[i][k] == 11){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 11, loader, 6));
				}else if(positions[i][k] == 12){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 12, loader, 7));
				}else if(positions[i][k] == 13){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 13, loader, 8));
				}else if(positions[i][k] == 14){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 14, loader, 9));
				}else if(positions[i][k] == 15){
					em.addEntity(new RoadTile((k*64) + (locX*576), (i*64) + (locY*576), 15, loader, 10));
				}else if(positions[i][k] == 16){
					em.addEntity(new TrashcanTile((k*64) + (locX*576), (i*64) + (locY*576), 16, loader));
				}else if(positions[i][k] == 17){
					em.addEntity(new WoodTile((k*64) + (locX*576), (i*64) + (locY*576), 17, loader));
				}else if(positions[i][k] == 18){
					em.addEntity(new ComputerdeskTile((k*64) + (locX*576), (i*64) + (locY*576), 18, loader, 0));
				}else if(positions[i][k] == 19){
					em.addEntity(new ComputerdeskTile((k*64) + (locX*576), (i*64) + (locY*576), 19, loader, 1));
				}else if(positions[i][k] == 20){
					em.addEntity(new MailboxTile((k*64) + (locX*576), (i*64) + (locY*576), 20, loader));
				}else if(positions[i][k] == 21){
					em.addEntity(new BedTile((k*64) + (locX*576), (i*64) + (locY*576), 21, loader));
				}else if(positions[i][k] == 22){
					em.addEntity(new BrickwallTile((k*64) + (locX*576), (i*64) + (locY*576), 22, loader, 0));
				}else if(positions[i][k] == 23){
					em.addEntity(new BrickwallTile((k*64) + (locX*576), (i*64) + (locY*576), 23, loader, 1));
				}else if(positions[i][k] == 24){
					em.addEntity(new BrickwallTile((k*64) + (locX*576), (i*64) + (locY*576), 24, loader, 2));
				}else if(positions[i][k] == 25){
					em.addEntity(new BrickwallTile((k*64) + (locX*576), (i*64) + (locY*576), 25, loader, 3));
				}else if(positions[i][k] == 26){
					em.addEntity(new BrickdoorwayTile((k*64) + (locX*576), (i*64) + (locY*576), 26, loader));
				}else if(positions[i][k] == 27){
					em.addEntity(new BrickcornerTile((k*64) + (locX*576), (i*64) + (locY*576), 27, loader, 0));
				}else if(positions[i][k] == 28){
					em.addEntity(new BrickcornerTile((k*64) + (locX*576), (i*64) + (locY*576), 28, loader, 1));
				}else if(positions[i][k] == 29){
					em.addEntity(new BrickcornerTile((k*64) + (locX*576), (i*64) + (locY*576), 29, loader, 2));
				}else if(positions[i][k] == 30){
					em.addEntity(new BrickcornerTile((k*64) + (locX*576), (i*64) + (locY*576), 30, loader, 3));
				}else if(positions[i][k] == 31){
					em.addEntity(new FlowerTile2((k*64) + (locX*576), (i*64) + (locY*576), 31, loader));
				}else if(positions[i][k] == 32){
					em.addEntity(new ShelfTile((k*64) + (locX*576), (i*64) + (locY*576), 32, loader));
				}else if(positions[i][k] == 33){
					em.addEntity(new CashregisterTile((k*64) + (locX*576), (i*64) + (locY*576), 33, loader));
				}
			}
		}
	}
	
	private int[][] processFile(String path){
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(prefixPath + path + ".txt");
		String line = null;
		int row = 0;
		int[][] positions = new int[mapSize][mapSize];
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			while((line = r.readLine()) != null){
				for(int i = 0; i < line.length()/2; i++){
					positions[row][i] = Integer.parseInt(line.substring((i*2), (i*2)+2));
				}
				row++;
			}
			r.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Unable to process file - " + path + "   - MapLoader");
			return null;
		}
		return positions;
	}
	
}
