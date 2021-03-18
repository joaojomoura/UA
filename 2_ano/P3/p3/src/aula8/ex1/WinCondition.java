/**
 * 
 */
package aula8.ex1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Joao Moura
 *
 */
public class WinCondition {
	
public static int checkWin(JButton [] button, int n) {
		
		if(		button[0].getText().equalsIgnoreCase("O") && 
				button[1].getText().equalsIgnoreCase("O")&&
				button[2].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[0].getText().equalsIgnoreCase("O") && 
				button[3].getText().equalsIgnoreCase("O") &&
				button[6].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[0].getText().equalsIgnoreCase("O") && 
				button[4].getText().equalsIgnoreCase("O") &&
				button[8].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[1].getText().equalsIgnoreCase("O") && 
				button[4].getText().equalsIgnoreCase("O") &&
				button[7].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[2].getText().equalsIgnoreCase("O") && 
				button[5].getText().equalsIgnoreCase("O") &&
				button[8].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[2].getText().equalsIgnoreCase("O") && 
				button[4].getText().equalsIgnoreCase("O") &&
				button[6].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[3].getText().equalsIgnoreCase("O") && 
				button[4].getText().equalsIgnoreCase("O") &&
				button[5].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(		button[6].getText().equalsIgnoreCase("O") && 
				button[7].getText().equalsIgnoreCase("O") &&
				button[8].getText().equalsIgnoreCase("O")){
					return -1; 
		}
		if(button[0].getText().equalsIgnoreCase("X") && 
				button[1].getText().equalsIgnoreCase("X") &&
				button[2].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[0].getText().equalsIgnoreCase("X") && 
				button[3].getText().equalsIgnoreCase("X") &&
				button[6].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[0].getText().equalsIgnoreCase("X") && 
				button[4].getText().equalsIgnoreCase("X") &&
				button[8].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[1].getText().equalsIgnoreCase("X") && 
				button[4].getText().equalsIgnoreCase("X") &&
				button[7].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[2].getText().equalsIgnoreCase("X") && 
				button[5].getText().equalsIgnoreCase("X") &&
				button[8].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[2].getText().equalsIgnoreCase("X") && 
				button[4].getText().equalsIgnoreCase("X") &&
				button[6].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[3].getText().equalsIgnoreCase("X") && 
				button[4].getText().equalsIgnoreCase("X") &&
				button[5].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		if(		button[6].getText().equalsIgnoreCase("X") && 
				button[7].getText().equalsIgnoreCase("X") &&
				button[8].getText().equalsIgnoreCase("X")){
					return 1; 
		}
		
		if(n == 9)
			return 0;
		return 3;
	}
	
	public static void popUPWindow(JFrame frame,int win) {
		if(win == 1) {
			JOptionPane.showMessageDialog(frame.getContentPane(), "Player X won");
			System.exit(0);
		}
		else if(win == -1) {
			JOptionPane.showMessageDialog(frame.getContentPane(), "Player O won");
			System.exit(0);
		}
		else if(win == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(), "Draw");
			System.exit(0);
		}
		
	}

}
