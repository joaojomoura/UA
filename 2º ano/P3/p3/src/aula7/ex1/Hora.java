/**
 * 
 */
package aula7.ex1;

/**
 * @author João Moura
 *
 */
public class Hora implements Comparable<Hora>{
	/**
	 * @Atributos
	 */
	private int minutos;
	private int horas;
	private int tempoEmMinutos;
	
	/**
	 * @Construtor
	 * @param minutos
	 * @param horas
	 */
	public Hora(int horas, int minutos) {
		this.minutos = minutos;
		this.horas = horas;
		tempoEmMinutos = minutos + horas * 60;
	}
	/**
	 * @Construtor default
	 */
	public Hora () {
		this(0,0);
	}

	/**
	 * @return the minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @return the tempoEmMinutos
	 */
	public int getTempoEmMinutos() {
		return tempoEmMinutos;
	}
	
	/**
	 * 
	 * @param minutos
	 * @return 
	 */
	public static String minutosEmHorasString(int minutos) {
		int min = minutos % 60;
		int hor = minutos / 60;
		return hor + ":" + min;
	}
	
	/**
	 * 
	 * @param h
	 * @param delay
	 * @return hora nova com o atraso adicionado
	 */
	public Hora newHora(Hora h, Hora delay) {
		int tmp = h.tempoEmMinutos + delay.tempoEmMinutos;
		return (new Hora(tmp / 60,tmp % 60));
	}
	
	@Override
	public String toString() {
		if(horas < 10)
			return "0" + horas + ":" + minutos;
		return horas + ":" + minutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + horas;
		result = prime * result + minutos;
		result = prime * result + tempoEmMinutos;
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
		Hora other = (Hora) obj;
		if (horas != other.horas)
			return false;
		if (minutos != other.minutos)
			return false;
		if (tempoEmMinutos != other.tempoEmMinutos)
			return false;
		return true;
	}

	@Override
	public int compareTo(Hora o) {
		if(this.horas > o.horas)
			return 1;
		else if(this.horas == o.horas && this.minutos > o.minutos)
			return 1;
		else if(this.horas == o.horas && this.minutos == o.minutos)
			return 0;
		else
			return -1;
	}
	
	

}
