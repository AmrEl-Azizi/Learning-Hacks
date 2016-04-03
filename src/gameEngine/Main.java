package gameEngine;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	private static final Dimension gameSize = new Dimension(566, 566);
	private static final String gameTitle = "Learning Hax";
	public Main()
	{
		
	}
	public static void main(String args[]){
		Engine game = new Engine(gameSize);
		game.setPreferredSize(gameSize);
		game.setMaximumSize(gameSize);
		game.setMinimumSize(gameSize);
		JFrame frame = new JFrame(gameTitle);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.startGame();
	}
	
}
