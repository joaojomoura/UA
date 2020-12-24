/**
 * 
 */
package aula4.ex1;

import aula3.ex1.*;

/**
 * @author João Moura
 *
 */
public class Disciplina {
	
	//Atributos
	private String nomeDisciplina;
	private String areaCientifica;
	private int ects;
	private Professor responsavel;
	private Estudante [] alunos;
	private int numAlunos;
	
	
	//Construtor
	protected Disciplina(String nd, String d, int cts, Professor r) {
		nomeDisciplina = nd;
		areaCientifica = d;
		ects = cts;
		responsavel = r;
		alunos = new Estudante[100];
		numAlunos = 0;
	}

	//Getters
	/**
	 * @return the nomeDisciplina
	 */
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	/**
	 * @return the areaCientifica
	 */
	public String getAreaCientifica() {
		return areaCientifica;
	}

	/**
	 * @return the ects
	 */
	public int getEcts() {
		return ects;
	}

	/**
	 * @return the responsavel
	 */
	public Professor getResponsavel() {
		return responsavel;
	}

	
	
	// Metodos
	
	
	/**
	 * 
	 * @param aluno
	 * @return true se adiciona um aluno novo
	 */
	public boolean addAluno(Estudante aluno) {
		for(int i = 0; i < numAlunos; i++)
			if(alunos[i].equals(aluno))
				return false;
		alunos[numAlunos] = aluno;
		numAlunos++;
		return true;
		
	}
	
	/**
	 * 
	 * @param nmec
	 * @return true se o aluno de numero mec estiver inscrito
	 */
	public boolean alunoInscrito(int nmec) {
		if(numAlunos == 0) {
			System.out.println("Lista vazia");
			return false;
		}
		
		for(int i = 0; i < numAlunos;i++) {
			if(alunos [i].getNmec() == nmec)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return numero de alunos inscrito
	 */
	public int numAlunos() {
		return numAlunos;
	}
	
	
	/**
	 * 
	 * @param nmec
	 * @return true se o aluno for removido com sucesso
	 */
	public boolean delAluno(int nmec) {
		if(numAlunos == 0) {
			System.out.println("Lista vazia");
			return false;
		}
		
		int i = 0;
		for(i = 0; i < numAlunos; i++) {
			if(alunos [i].getNmec() == nmec)
				break;
		}
		
		Estudante [] tmp = new Estudante [numAlunos-1];
		
		for(int j = 0, k = 0; k < numAlunos; k++) {
			if(k == i)
				continue;
			tmp [j++] = alunos [k];
		}
		
		for (int j = 0; j < numAlunos-1; j++)
			alunos[j] = tmp [j];
		numAlunos--;
		return true;
		
	}
	
	/**
	 * 
	 * @return um aray da lista de alunos
	 */
	public Estudante[] getAlunos()
	{
		Estudante [] newList = new Estudante [numAlunos];
		for (int i = 0; i < numAlunos; i++) {
			newList[i] = alunos[i];
		}
		return newList;
	}
	
	/**
	 * 
	 * @param s
	 * @return um array com a lista de bolseiros
	 */
	public Estudante[] getAlunos(String s) {
		
		int k = 0;
		int bolseiros = 0;
		Estudante [] tipos = new Estudante [100];
		
		for(int i = 0; i < numAlunos; i++)
			if((alunos[i].getClass().toString()).contains(s)) {
				tipos [k++] = alunos[i];
				bolseiros = k;
			}
	
		Estudante [] newList = new Estudante [k];
		for (int i = 0; i < bolseiros; i++) {
			newList[i] = tipos[i];
		}
		return newList;
				
	}
	
	@Override
	public String toString()
	{
		return "Disciplina:" + nomeDisciplina + " ( " + ects + " ECTS) da area de " + areaCientifica + "\nResponsável: " + responsavel
				+ "\nExistem " + numAlunos + " alunos inscritos.";
	}
	

}
