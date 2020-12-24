/**
 * 
 */
package aula2.ex1;



/**
 * @author João Moura
 *
 */
public class Data {
	private int dia, mes, ano; 
	/**
	 * 
	 */
	
	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	
	}
	/**
	 * Construtor data
	 * @param dia
	 * @param mes
	 * @param ano
	 */
	public Data(int dia, int mes, int ano) {
		// TODO Auto-generated constructor stub
		dataValida(dia,mes,ano); // verifica se os argumentos sao validos
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	/** Dimensões dos meses num ano bissexto. */
	private static final
	  int[] diasMesComum = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	
	/** Indica se ano é bissexto. */
	private static boolean bissexto(int ano) {
	    return ((ano%4 == 0 && ano%100 != 0) || ano%400 == 0);
	}
	
	
	/** Indica se um terno (dia, mes, ano) forma uma data válida. */
	private void dataValida(int dia, int mes, int ano) {
		//validaçao do mes
		if(mes <= 0 || mes > 12)
			throw new RuntimeException("Mes invalido");
		//validaçao do dia
		else if (bissexto(ano) && diasMesComum[mes-1] < dia || dia < 0)
			throw new RuntimeException("Dia Invalido");
		
		else if (!bissexto(ano) && mes != 2 && diasMesComum[mes-1] < dia 
				|| dia < 0 || diasMesComum[1] - 1 < dia )
			throw new RuntimeException("Dia Invalido");
		//validaçao do ano
		else if(ano < 0)
			throw new RuntimeException("Ano invalido");	
	  }
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

}
