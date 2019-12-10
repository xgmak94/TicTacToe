import java.awt.Font;
import javax.swing.*;

public class Square extends JButton{
	int type = 0;
	String[] typeMark = {"", "X", "O"};
	
	public Square() {
		this.setFont(new Font("Times New Roman", Font.BOLD, 36));
	}
	
	public void place(boolean PLAYER_TURN) {
		if(PLAYER_TURN) {
			this.type = 1;
		}
		else {
			this.type = 2;
		}
		this.setText(typeMark[type]);
		disallow();
	}

	public void allow() {
		this.setEnabled(true);
	}
	
	public void disallow() {
		this.setEnabled(false);
	}
	
	public void clear() {
		this.allow();
		this.type = 0;
		this.setText("");
	}
	
}
