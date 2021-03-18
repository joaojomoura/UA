/**
 * 
 */
package aula2.ex1;


/**
 * @author João Moura
 *
 */
public class Aluno extends Socio{
	
	//variaveis
	private final int nmec;
	private final String curso;
	
	//construtor
	
	public Aluno (String n,int c, Data insc, Data nas, int mec, String cur,int l) {
		super(n,c,insc,nas,l);
		nmec = mec;
		curso = cur;
	}

	
	//getters
	public int getNmec() {
		return nmec;
	}

	public String getCurso() {
		return curso;
	}
	
	
	
	public String toString() {
		return "Socio nº " + super.getnSocio() + "/n	Aluno:  " + nmec + 
				"/n 	Nome: " + super.getNome() + "/n		Curso: " + curso;
	}

}
