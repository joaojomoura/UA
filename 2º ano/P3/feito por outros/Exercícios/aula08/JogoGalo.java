package aula08;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JToggleButton;

public class JogoGalo extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -5086383841925781504L;
		private JToggleButton b1 = new JToggleButton("");
		private JToggleButton b2 = new JToggleButton("");
		private JToggleButton b3 = new JToggleButton("");
		private JToggleButton b4 = new JToggleButton("");
		private JToggleButton b5 = new JToggleButton("");
		private JToggleButton b6 = new JToggleButton("");
		private JToggleButton b7 = new JToggleButton("");
		private JToggleButton b8 = new JToggleButton("");
		private JToggleButton b9 = new JToggleButton("");
		private String jogador = "X"; //Jogador Inicial X
		private boolean gameOver = false;
		private int contador = 0; 
		
		public JogoGalo() {
			setTitle("JogoDoGalo\r\n");
			getContentPane().setLayout(new GridLayout(3,3));
			setSize(300,300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		getContentPane().add(b4);
		getContentPane().add(b5);
		getContentPane().add(b6);
		getContentPane().add(b7);
		getContentPane().add(b8);
		getContentPane().add(b9);
		
		b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    b5.addActionListener(this);
	    b6.addActionListener(this);
	    b7.addActionListener(this);
	    b8.addActionListener(this);
	    b9.addActionListener(this);
		
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent a) {
		contador++;
		
		if(a.getSource() == b1){
			b1.setText(jogador);
			b1.setEnabled(false);
		}	
		else if(a.getSource() == b2){
			b2.setText(jogador);
			b2.setEnabled(false);
		}	
		else if(a.getSource() == b3){
			b3.setText(jogador);
			b3.setEnabled(false);
		}	
		else if(a.getSource() == b4){
			b4.setText(jogador);
			b4.setEnabled(false);
		}	
		else if(a.getSource() == b5){
			b5.setText(jogador);
			b5.setEnabled(false);
		}	
		else if(a.getSource() == b6){
			b6.setText(jogador);
			b6.setEnabled(false);
		}	
		else if(a.getSource() == b7){
			b7.setText(jogador);
			b7.setEnabled(false);
		}	
		else if(a.getSource() == b8){
			b8.setText(jogador);
			b8.setEnabled(false);
		}	
		else if(a.getSource() == b9){
			b9.setText(jogador);
			b9.setEnabled(false);
		}	
		verifica();
		if(gameOver==true){
			JOptionPane.showMessageDialog(null, "O jogador " +jogador+ " ganhou!");
			System.exit(0);
			
		}
		else if(contador==9 && gameOver==false){
			JOptionPane.showMessageDialog(null, "Empate");
			System.exit(0);
		}
			
		jogadorP();
	}
	
	
	
	//Próximo jogador
	private void jogadorP(){
		if(jogador=="X")
			jogador="O";
		else
			jogador="X";
	}
	
	
	//Verifica Quem Ganhou
	private void verifica(){
		
		//Horizontal
        if( b1.getText() == b2.getText() && b2.getText() == b3.getText() && b1.getText() != "")
            gameOver = true;
        
        else if(b4.getText() == b5.getText() && b5.getText() == b6.getText() && b4.getText() != "")
        	gameOver = true;
        
        else if(b7.getText() == b8.getText() && b8.getText() == b9.getText() && b7.getText() != "")
        	gameOver = true;
        
        
        //Vertical
        else if(b1.getText() == b4.getText() && b4.getText() == b7.getText() && b1.getText() != "")
        	gameOver = true;
        
        else if(b2.getText() == b5.getText() && b5.getText() == b8.getText() && b2.getText() != "")
        	gameOver = true;
        
        else if(b3.getText() == b6.getText() && b6.getText() == b9.getText() && b3.getText() != "")
        	gameOver = true;
        
        //Diagonal
        else if(b1.getText() == b5.getText() && b5.getText() == b9.getText() && b1.getText() != "")
        	gameOver = true;
        
        else if(b3.getText() == b5.getText() && b5.getText() == b7.getText() && b3.getText() != "")
        	gameOver = true;
        
        else 
        	gameOver = false;
        
		
	}
	
	
}
