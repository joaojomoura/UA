/**
 * 
 */
package aula6.ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author João Moura
 *
 */
public class Ementa {
	
	private final String nome, local;
	private final HashMap<DiaSemana, Lista<Prato>> pratos = new HashMap<>();
	
	public Ementa (String n, String l) {
		nome = n;
		local = l;
	}
	
	public Prato[] getPratPorDia(int k){
		Lista<Prato> newList = pratos.get(DiaSemana.enumDay(k));
		Prato[] tmp = new Prato[newList.size()];
		int i = 0;
		for(Prato p : newList.toArray(new Prato[0])) {
			tmp[i++] = p;
		}
		return tmp;
	}
	
	public void addPrato(Prato prato, DiaSemana dia) {
		if(pratos.containsKey(dia))
			pratos.get(dia).insert(prato);
		else {
			Lista<Prato> tmp = new Lista<>();
			tmp.insert(prato);
			pratos.put(dia, tmp);
		}
	}
	
	public void deletePrato (Prato prato, DiaSemana dia) {
		if(pratos.containsKey(dia))
			if(pratos.get(dia).contains(prato))
				pratos.get(dia).delete(prato);		
	}
	
	public void storeEmenta()
	throws IOException
	{
		Scanner k = new Scanner(System.in);
		System.out.print("Nome do ficheiro: ");
		String filename = k.nextLine();
		PrintWriter printer = new PrintWriter(new File(filename));
		printer.print(this.toString());
		printer.close();
	}
	
	@Override
	public String toString() {
		String s = "";
		DiaSemana[] sorted = pratos.keySet().toArray(new DiaSemana[0]);
		Arrays.sort(sorted);
		for(DiaSemana dia : sorted) {
			Lista<Prato> list = pratos.get(dia);
			for(Prato p : list.toArray(new Prato[0])) {
				s += p.toString()+", dia "+dia+"\n";
			}
		}
		return s;
	}
	

}

enum DiaSemana
{
	SEGUNDA(0), TERÇA(1), QUARTA(2), QUINTA(3), SEXTA(4), SÁBADO(5), DOMINGO(6);
	
	private int dia;
	
	private DiaSemana(int i)
	{
		dia = i;
	}
	
	public int getDay()
	{
		return this.dia;
	}
	
	public static DiaSemana rand()
	{
		int i = (int)(Math.random() * 6);
		for (DiaSemana dia : values())
			if (dia.getDay() == i)
				return dia;
		return DOMINGO;
	}
	
	public static DiaSemana enumDay(int n) {
		DiaSemana var = null;
		for(DiaSemana v : DiaSemana.values()) {
			if(v.getDay() == n) return v;
		}
		return var;
	}
}
