/**
 * 
 */
package aula2.ex1;

import java.util.*;
import static java.lang.System.*;

/**
 * @author João Moura
 *
 */
public class ListaSocios {
		
	//variaveis
	private Hashtable <Integer,Aluno> listaAl;
	private Hashtable <Integer,Funcionario> listaf;
	
	//Construtor
	public ListaSocios () {
		listaAl = new Hashtable <Integer,Aluno>();
		listaf = new Hashtable <Integer,Funcionario>();
	}
	
	/*
	 * 
	 * Operaçoes
	 * 
	 */
	
	
	//Inserçao de aluno/Funcionario 
	public void putAluno (Aluno a) {
		listaAl.put(a.getnSocio(), a);
	}
	
	public void putFunc (Funcionario f) {
		listaf.put(f.getnSocio(), f);
	}
	
	
	//remoçao
	public Funcionario remFunc(int s)
	{
		return listaf.remove(s);
	}
	
	public Aluno remAl(int s)
	{
		return listaAl.remove(s);
	}
	
	// obtençao
	public Funcionario getFunc(int s)
	{
		return listaf.get(s);
	}
	
	public Aluno getAluno(int s)
	{
		return listaAl.get(s);
	}
	
	//verificaçao se tem na lista
	public boolean temAluno(int s)
	{
		return listaAl.contains(s);
	}
	
	public boolean temFunc(int s)
	{
		return listaf.contains(s);
	}
	
	//tamanho da lista
	public int lastSocNumb()
	{
		return listaAl.size() + listaf.size();
	}
	
	
	public boolean containsAlunSoc(int s)
	{
		return listaAl.containsKey(s);
	}
	
	public boolean containsFunSoc(int s)
	{
		return listaf.containsKey(s);
	}
	
	public void printLista () {
		if(listaAl.size() == 0)
			out.println("Lista Vazia");
		else
			out.printf("%s%n",listaAl);
		if(listaf.size() == 0)
			out.println("Lista Vazia");
		else
			out.printf("%s%n", listaf);
	}
	
	
}
