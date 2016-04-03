package gameFramework;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import gameGraphics.ImageLoader;
import gameInterface.Key;

public class DialogueController {
	private ImageLoader loader;
	private Key key;
	private int index, previndex;
	public boolean M1, M2, M3, T1, T2, SC1, C1, C2, MB1, MB2, TR1, TR2, CR1, HW1, DR1, DR2, DR3, S1, S2, DS1, DS2,
			inDialogue, boxChecker, lockKeys;
	public int M, T, C, TR, MB, DR;
	private DialogueBox b;
	private String name;

	public DialogueController(Key _key, ImageLoader _loader) {
		loader = _loader;
		key = _key;
		index = 0;
		previndex = 0;
		M1 = true;
		M2 = false;
		M3 = false;
		T1 = false;
		T2 = false;
		SC1 = false;
		C1 = false;
		C2 = false;
		MB1 = false;
		MB2 = false;
		TR1 = false;
		TR2 = false;
		CR1 = false;
		HW1 = false;
		DR1 = false;
		DR2 = false;
		DR3 = false;
		DS1 = false;
		DS2 = false;
		lockKeys = false;
		M = 0;
		T = 0;
		C = 0;
		TR = 0;
		MB = 0;
		DR = 0;
		inDialogue = false;
		boxChecker = false;
		b = null;
		name = null;
	}

	public void M001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("M001-dia0", loader, name);
			boxChecker = true;

		}
		// System.out.println(index);
		if (previndex != index && (previndex == 4 || previndex == 6))
			index = 10;
		if (index == 2) {
			if (key.is1()) {
				index = 4;
				key.set1(false);
			} else if (key.is2()) {
				index = 6;
				key.set2(false);
			} else if (key.is3()) {
				index = 8;
				key.set3(false);
			}
		} else if (index > 10) {
			index = 0;
			M1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void M002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("M002-dia0", loader, name);
			boxChecker = true;
		}
		if (index >= 2) {
			index = 0;
			M2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void M003(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("M003-dia0", loader, name);
			boxChecker = true;
		}
		if (index >= 2) {
			index = 0;
			M3 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void T001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("T001-dia0", loader, name);
			boxChecker = true;
		}
		if (index >= 2) {
			index = 0;
			T1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void T002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("T002-dia0", loader, name);
			boxChecker = true;
		}
		if (index >= 2) {
			index = 0;
			T2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void SC001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("SC001-dia0", loader, name);
			boxChecker = true;
		}
		if (index == 8) {
			if (key.isEnter()) {
				String s = JOptionPane.showInputDialog("Declare an int called num");
				if (s != null && s.equals("int num;"))
					index += 2;
				else
					JOptionPane.showMessageDialog(null, "That was incorrect, try again. Hint - End with a semicolon");
			}
		} else if (index == 10) {
			if (key.isEnter()) {
				String s = JOptionPane.showInputDialog(
						"Declare a character called letter - Hint: The keyword for character is “char”");
				if (s != null && s.equals("char letter;"))
					index += 2;
				else
					JOptionPane.showMessageDialog(null, "That was incorrect, try again. Hint - End with a semicolon");
			}
		} else if (index == 18) {
			if (key.isEnter()) {
				String s = JOptionPane.showInputDialog("Create and Initialize an age int");

				try {
					int i = s.indexOf(';');
					s.substring(11, i);
					if (s.substring(0, 10).equals("int age = ") && i > 8)
						index += 2;
					else
						JOptionPane.showMessageDialog(null, "That was incorrect, try again.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "That was incorrect, try again.");
				}
			}
		} else if (index == 24) {
			if (key.isEnter()) {
				String s = JOptionPane.showInputDialog("Initialize a String called name");
				try {
					int i = s.indexOf(';');
					name = s.substring(15, i - 1);
					if (s.substring(0, 14).equals("String name = ") && i > 14)
						index += 2;
					else
						JOptionPane.showMessageDialog(null, "That was incorrect, try again.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "That was incorrect, try again.");
				}
			}
		} else if (index > 30) {
			index = 0;
			SC1 = false;
			boxChecker = false;
		} else {
			inDialogue = true;
		}
		b.render(g, index);
		lockKeys = true;
	}

	public void C001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("C001-dia0", loader, name);
			boxChecker = true;
		}
		if (previndex != index && (previndex == 6))
			index = 12;
		if (index == 2) {
			if (key.is1()) {
				index = 4;
				key.set1(false);
			} else if (key.is2()) {
				index = 8;
				key.set2(false);
			}
		} else if (index >= 14) {
			index = 0;
			C1 = false;
			boxChecker = false;
		} else
			inDialogue = true;

		b.render(g, index);
		lockKeys = true;
	}

	public void C002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("T002-dia0", loader, name);
			boxChecker = true;
		}
		if (index >= 2) {
			index = 0;
			C2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void MB001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("MB001-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 8) {
			index = 0;
			MB1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void MB002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("MB002-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			MB2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void TR001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("TR001-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			TR1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void TR002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("TR002-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			TR2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void CR001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("CR001-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			CR1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void HW001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("HW001-dia0", loader, name);
			boxChecker = true;
		}

		if (index == 4) {
			if (key.isEnter()) {
				String s = JOptionPane.showInputDialog(
						"Declare a character called letter - Hint: The keyword for character is “char”");
				if (s != null && s.equals("System.out.println(\"Hello World\");"))
					index += 2;
				else
					JOptionPane.showMessageDialog(null,
							"That was incorrect, try again. - Hint: Remeber strings require quotes.");
			}
		} else if (index >= 8) {
			index = 0;
			HW1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void DR001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("DR001-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 4) {
			index = 0;
			DR1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void DR0020(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("DR002-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			DR2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void DR0021(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("DR002-dia1", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			DR3 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void S001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("S001-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			S1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void S002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("S002-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			S2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void DS001(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("DS001-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			DS1 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void DS002(Graphics g) {
		if (!boxChecker) {
			b = new DialogueBox("DS002-dia0", loader, name);
			boxChecker = true;
		}

		if (index >= 2) {
			index = 0;
			DS2 = false;
			boxChecker = false;
		} else
			inDialogue = true;
		b.render(g, index);
		lockKeys = true;
	}

	public void render(Graphics g) {
		if (inDialogue && key.isEnter()) {
			index += 2;
			key.setEnter(false);
		}
		inDialogue = false;
		lockKeys = false;
		if (M1)
			this.M001(g);
		else if (M2)
			this.M002(g);
		else if (M3)
			this.M003(g);
		else if (T1)
			this.T001(g);
		else if (T2)
			this.T002(g);
		else if (SC1)
			this.SC001(g);
		else if (C1)
			this.C001(g);
		else if (MB1)
			this.MB001(g);
		else if (MB2)
			this.MB002(g);
		else if (TR1)
			this.TR001(g);
		else if (TR2)
			this.TR002(g);
		else if (CR1)
			this.CR001(g);
		else if (HW1)
			this.HW001(g);
		else if (DR1)
			this.DR001(g);
		else if (DR2)
			this.DR0020(g);
		else if (DR3)
			this.DR0021(g);
		else if (S1)
			this.S001(g);
		else if (S2)
			this.S002(g);
		else if (DS1)
			this.DS001(g);
		else if (DS2)
			this.DS002(g);
		key.setEnter(false);
		previndex = index;
	}
}
