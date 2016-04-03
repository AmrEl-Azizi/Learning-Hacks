package gameFramework;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import gameGraphics.ImageLoader;

public class DialogueBox {

	private ArrayList<String> dialogue;
	private String Identifier;
	private BufferedImage img;
	private Font f1;
	private Font f2;
	private String name;

	public DialogueBox(String _Identifier, ImageLoader loader, String name) {
		img = loader.loadImage("/Other/dialogBox.png");
		dialogue = new ArrayList<String>();
		Identifier = _Identifier;
		loadDialogFile();
		processDialogFile();
		f1 = new Font("Verdana", Font.BOLD, 28);
		f2 = new Font("Verdana", Font.PLAIN, 14);
		this.name = name;
		
	}

	public void loadDialogFile() {
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dialogue.txt");
		String line = null;
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			while ((line = r.readLine()) != null) {
				if (line.startsWith(Identifier))
					dialogue.add(line);
			}
			r.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g, int i) {
		g.drawImage(img, 0, 448, null);
		g.setFont(f1);
		g.drawString(dialogue.get(i), 5, 448 + 30);
		g.setFont(f2);
		String s = dialogue.get(i + 1);
		ArrayList<String> li = new ArrayList<String>();
		for (int x = 0; x < s.length() - 1; x++)
			if (s.substring(x, x + 2).equals("/n")) {
				li.add(s.substring(0, x));
				s = s.substring(x + 2);
				x = 0;
			} else if (x > 70 && s.charAt(x) == ' ') {
				li.add(s.substring(0, x + 1));
				s = s.substring(x + 1);
				x = 0;
			} else if (s.length() - x >= 9 && s.substring(x, x + 9).equals("Character")) {
				s = s.substring(0, x) + name + s.substring(x + 9);
			}
		li.add(s);
		for (int u = 0; u < li.size(); u++)
			g.drawString(li.get(u), 5, 448 + 60 + 30 * u);
	}

	public void processDialogFile() {
		for (int i = 0; i < dialogue.size(); i++) {
			dialogue.set(i, dialogue.get(i).substring(Identifier.length() + 6));
		}

	}
}
