/**
 * 
 */
package aula8.ex1;
import java.awt.*;
import javax.swing.*;

/**
 * @author João Moura
 *
 */
public class JogoGalo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 75264722956L;
	static int n =0;
	static boolean player = true;
	public static void main(String[] args) {
		
		/**
		 * Layout do board
		 */
		JFrame frame = new JFrame("Jogo do Galo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(210, 210);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		
		
		JButton [] button = new JButton [9];// numero de butoes
		
		/**
		 * Adicionar butoes ao board e o que acontece quando carrega
		 */
		for(int i = 0; i < button.length; i++) {
			button[i] = new JButton(" ");
			button[i].setFont(new Font("Lucida Sans Unicode",Font.BOLD,50));
			panel.add(button[i]);
			JButton tmp = button[i];
			button[i].addActionListener(e -> {
										if(player) {tmp.setText("X");player = false;}
										else {tmp.setText("O");player = true;} 
										tmp.setEnabled(false);
										n++;
										WinCondition.popUPWindow(frame, WinCondition.checkWin(button,n));});
		}
		
		frame.setContentPane(panel);
		frame.setVisible(true);

	}
	
	

}
