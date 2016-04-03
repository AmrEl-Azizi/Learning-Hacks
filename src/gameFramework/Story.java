package gameFramework;

import java.awt.Graphics;

import gameEntities.Entity;
import gameEntities.NPC;
import gameEntities.EntityManager;
import gameGraphics.ImageLoader;
import gameInterface.Key;

public class Story {

	private DialogueController DiaCont;
	private Key key;
	private ImageLoader loader;
	private EntityManager em;
	private Entity npc, tile;
	private String ident;
	private int id;
	private boolean T, choresComplete,a;

	public Story(Key _key, ImageLoader _loader, EntityManager em) {
		this.key = _key;
		this.loader = _loader;
		this.em = em;
		DiaCont = new DialogueController(key, loader);
		this.ident = null;
		T = false;
		a = true;
	}

	public DialogueController getDiaCont() {
		return this.DiaCont;
	}

	public void tick() {
		if (DiaCont.lockKeys)
			return;
		npc = em.getNPC();
		if (npc != null && key.isEnter()) {
			ident = ((NPC) npc).getIdentifier();
			System.out.println(ident);
			if (ident.equals("M")) {
				if (DiaCont.T == 0) {
					DiaCont.M2 = true;
				} else if (DiaCont.T == 1) {
					DiaCont.M3 = true;
				}
			} else if (ident.equals("T")) {
				if (DiaCont.T == 0) {
					DiaCont.T1 = true;
					T = true;
				} else if (DiaCont.T == 1) {
					DiaCont.T2 = true;
				}
			} else if (ident.equals("C")) {
				if (DiaCont.C == 0) {
					DiaCont.C1 = true;
					DiaCont.C++;
				} else if (DiaCont.C == 1)
					DiaCont.C2 = true;
			} else if (ident.equals("S")) {
				if (DiaCont.T == 0)
					DiaCont.S1 = true;
				else if (DiaCont.T == 1)
					DiaCont.S2 = true;
			} else if (ident.substring(0, 2).equals("DR")) {
				if (DiaCont.DR == 0) {
					DiaCont.DR1 = true;
					DiaCont.DR++;
				} else if (ident.equals("DRW"))
					DiaCont.DR2 = true;
				else
					DiaCont.DR3 = true;
			} else if (ident.equals("DS")) {
				if (DiaCont.T == 0)
					DiaCont.DS1 = true;
				else if (DiaCont.T == 1)
					DiaCont.DS2 = true;
			}
		}
		tile = em.getTile();
		if (tile != null && key.isEnter()) {
			id = tile.getID();
			if (id == 19 && T) {
				DiaCont.SC1 = true;
				DiaCont.T++;
				T = false;
			} else if (id == 20 && DiaCont.T == 1) {
				if (DiaCont.MB == 0) {
					DiaCont.MB1 = true;
					DiaCont.MB++;
				} else if (DiaCont.MB == 1) {
					DiaCont.MB2 = true;
				}
			} else if (id == 16 && DiaCont.T == 1) {
				if (DiaCont.TR == 0) {
					DiaCont.TR1 = true;
					DiaCont.TR++;
				} else if (DiaCont.TR == 1) {
					DiaCont.TR2 = true;
				}
			} else if (id == 19 && choresComplete)
				DiaCont.HW1 = true;
		}

		if (!choresComplete && DiaCont.MB == 1 && DiaCont.TR == 1 && DiaCont.C == 1)
			choresComplete = true;
		if(a && !T && !DiaCont.SC1 && DiaCont.T == 1)
		{
			for(int i = 0; i < em.getNpcList().size(); i ++)
			{
				((NPC)em.getNpcList().get(i)).setRotate(-1);
			}
			a = false;
		}
	}

	public void render(Graphics g) {
		DiaCont.render(g);
	}
}