import javax.swing.*;

public class turnButton extends JButton{
	String[] player = {"PLAYER 1", "PLAYER 2"};
	int currPlayer = 1;
	
	public turnButton() {
		reset();
	}
	
	public void reset() {
		currPlayer = 0;
		setText();
	}
	
	public void swapPlayer() {
		if(currPlayer == 0) {
			currPlayer = 1;
		}
		else {
			currPlayer = 0;
		}
		setText();
	}
	
	public void setText() {
		this.setText(player[currPlayer]);
	}
}
