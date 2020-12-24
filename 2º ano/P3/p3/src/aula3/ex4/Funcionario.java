/**
 * 
 */
package aula3.ex4;

/**
 * @author João Moura
 *
 */
public class Funcionario extends Socio{
	
	//variaveis
	private final int nfiscal;
	private final int nfunc;
	
	
	
	//Construtor
	public Funcionario(String n,int c, Data insc, Data nas, int fis, int nf, int l) {
		super(n,c,insc,nas,l);
		nfiscal = fis;
		nfunc = nf;
	}

	//getters
	public int getNfiscal() {
		return nfiscal;
	}

	public int getNfunc() {
		return nfunc;
	}
	
	public String toString() {
		return "Socio nº " + super.getnSocio() + "/n	Funcionario:  " + nfunc + 
				"/n 	Nome: " + super.getNome() + "/n		NIF: " + nfiscal;
	}

}
