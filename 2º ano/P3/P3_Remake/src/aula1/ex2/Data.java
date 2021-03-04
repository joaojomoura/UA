/**
 * 
 */
package aula1.ex2;

import java.util.Arrays;

/**
 * @author slowbro
 *
 */
public class Data {
	private int dia,mes,ano;
	
	public Data (int dia,int mes,int ano) throws NumberFormatException {
		validation_data(dia, mes, ano);
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	
	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}


	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}


	/**
	 * @return the ano
	 */
	public int getAno() {
		return ano;
	}

	
	int [] common_year = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return the error result of invalid input
	 */
	protected void validation_data(int day, int month, int year) {
		if(year < 0)
			throw new NumberFormatException("Ano invalido!");
		if(month <= 0 || month > 12)
			throw new NumberFormatException("Mes invalido");
		if(leap_year(year)) {
			common_year[1] = 29;
			if(day <= 0 || day > common_year[month])
				throw new NumberFormatException("Dia invalido");
			common_year[1] = 28;
		}
		else {
			if(day <= 0 || day > common_year[month])
				throw new NumberFormatException("Dia invalido");
		}
		
		
		
	}
	
	/**
	 * 
	 * @param year
	 * @return true if it is a leap year
	 */
	protected boolean leap_year(int year) {
		return ((year%4 == 0 && year%100 != 0) || year%400 == 0);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + Arrays.hashCode(common_year);
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (ano != other.ano)
			return false;
		if (!Arrays.equals(common_year, other.common_year))
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	

}
