/**
 * 
 */
package aula3.ex3;
import static java.lang.System.out;

import aula1.ex2.*;
/**
 * @author João Moura
 *
 */
public class Condutor extends Pessoa{
	
	private String cartaconducao;

	public Condutor(String nome, int cc, Data dataNasc, String c) {
		super(nome, cc, dataNasc);
		if (!c.equalsIgnoreCase("A") && !c.equalsIgnoreCase("B") && 
				!c.equalsIgnoreCase("C") && !c.equalsIgnoreCase("D"))
			throw new IllegalArgumentException("Carta não válida");
		cartaconducao = c;
	}

	public String getCartaConducao() {
		return cartaconducao;
	}
	
	@Override
	public String toString()
	{
		return "Condutor: " + super.nome() + " | Carta : " + cartaconducao;
	}
	public void tipoDeCarta () {
		if(cartaconducao.equalsIgnoreCase("a"))
			out.println("Só Motociclos");
		if(cartaconducao.equalsIgnoreCase("b"))
			out.println("Motociclos e Ligeiros");
		if(cartaconducao.equalsIgnoreCase("c"))
			out.println("Motociclos, Ligeiros e Pesado de Mercadorias");
		if(cartaconducao.equalsIgnoreCase("d"))
			out.println("Motociclos, Ligeiros, Pesados de Mercadorias e Pesados de Passageiros");
	}
	
	
	
	

}
