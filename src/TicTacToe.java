import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
public class TicTacToe extends JFrame{

	int WINDOWSIZE_X = 720;
	int WINDOWSIZE_Y = 480;
	
	int GRIDSIZE_X = 3;
	int GRIDSIZE_Y = 3;
	int GRIDGAP_X = 5;
	int GRIDGAP_Y = 5;
	
	String RESTARTTEXT = "RESTART";
	
	JPanel window;
	JPanel grid;
	Square[][] squares;
	
	JPanel topButtons;
	turnButton turn;
	JButton restart;
	
	boolean playerTurn = true;
	boolean GAMEOVER = false;
	public TicTacToe(){
		super("Tic Tac Toe");
					
		turn = new turnButton();
		restart = new JButton(RESTARTTEXT);
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reinitialize();
			}
		});
		topButtons = new JPanel();
		topButtons.add(turn);
		topButtons.add(restart);
		
		setGrid();
		setWindow();
		
		this.setContentPane(window);
		
	}
	
	public void setGrid() {
		grid = new JPanel(new GridLayout(GRIDSIZE_X,GRIDSIZE_Y,GRIDGAP_X,GRIDGAP_Y));
		squares = new Square[GRIDSIZE_X][GRIDSIZE_Y];
		for(int i = 0 ; i < GRIDSIZE_X ; i++) {
			for(int j = 0 ; j < GRIDSIZE_Y ; j++) {
				squares[i][j] = new Square();
				squares[i][j].setPreferredSize(new Dimension(WINDOWSIZE_X/6, WINDOWSIZE_Y/6));
				squares[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Square src = (Square) e.getSource();
						src.place(playerTurn);
						
						if(gameCheck()) {
							 gameOver();
							 return;
						};
						
						playerTurn = !playerTurn;
						turn.swapPlayer();
					}
				});
				grid.add(squares[i][j]);
			}
		}
	}
	
	public void setWindow() {
		window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
		window.add(topButtons);
		window.add(grid);
	}
	
	public void reinitialize() {
		for(int i = 0 ; i < GRIDSIZE_X ; i++) {
			for(int j = 0 ; j < GRIDSIZE_Y ; j++) {
				squares[i][j].clear();
				playerTurn = true;
			}
		}
		turn.reset();
	}
	
	public void gameOver() {
		for(int i = 0 ; i < GRIDSIZE_X ; i++) {
			for(int j = 0 ; j < GRIDSIZE_Y ; j++) {
				squares[i][j].disallow();
				turn.setText("Game Over");
			}
		}
	}
	
	public boolean gameCheck() {
		for(int i = 0 ; i < GRIDSIZE_X ; i++) {
			if(checkRow(i))
				return true;
		}		
		for(int i = 0 ; i < GRIDSIZE_Y ; i++) {
			if(checkCol(i))
				return true;
		}		
		if(checkDiag())
			return true;
		
		return false;
	}
	
	public boolean checkRow(int row) {
		int type = squares[row][0].type;
		if(type == 0)
			return false;
		
		if(type == squares[row][1].type && type == squares[row][2].type) {
			return true;
		}
		return false;
	}
	
	public boolean checkCol(int col) {		
		int type = squares[0][col].type;
		if(type == 0)
			return false;
		
		if(type == squares[1][col].type && type == squares[2][col].type) {
			return true;
		}		
		return false;
	}
	
	public boolean checkDiag() {
		int type = squares[1][1].type;
		if(type == 0)
			return false;
		
		if(type == squares[0][0].type && type == squares[2][2].type) {
			return true;
		}	
		if(type == squares[0][2].type && type == squares[2][0].type) {
			return true;
		}			
		return false;
	}

}
