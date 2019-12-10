import java.awt.Dimension;

import javax.swing.JFrame;


public class main {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.setSize(new Dimension(720, 480));
		game.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		game.setVisible(true);
		game.setResizable(false);
			
		game.pack();
	}

}