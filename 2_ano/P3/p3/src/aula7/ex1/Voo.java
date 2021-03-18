/**
 * 
 */
package aula7.ex1;

/**
 * @author João Moura
 *
 */
public class Voo {
	/**
	 * Atributos
	 */
	private Hora hora, atraso;
	private String aviao, origem, prevista;
	private Companhia companhia;
	
	/**
	 * @Construtor
	 * @param hora
	 * @param aviao
	 * @param comp
	 * @param origem
	 * @param atraso
	 */
	public Voo (String hora, String aviao, Companhia comp, 
			String origem, String atraso) {
		
		String [] tmp = hora.split(":");
		this.hora = new Hora(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
		this.aviao = aviao;
		companhia = comp;
		this.origem = origem;
		tmp = atraso.split(":");
		this.atraso =  new Hora(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
		obs();
	}
	
	public Voo (String hora, String aviao, Companhia companhia, String origem)
	{
		this(hora, aviao, companhia, origem, "0:0");
	}

	/**
	 * calcula a hora prevista
	 */
	private void obs(){
		Hora tmp = new Hora();
		if(atraso.equals(new Hora()))
			prevista = "";
		else
			prevista = tmp.newHora(hora, atraso).toString(); 
	}
	/**
	 * @return the hora
	 */
	public Hora getHora() {
		return hora;
	}

	

	/**
	 * @return the atraso
	 */
	public Hora getAtraso() {
		return atraso;
	}

	

	/**
	 * @return the prevista
	 */
	public String getPrevista() {
		return prevista;
	}

	

	/**
	 * @return the aviao
	 */
	public String getAviao() {
		return aviao;
	}

	

	/**
	 * @return the origem
	 */
	public String getOrigem() {
		return origem;
	}

	

	/**
	 * @return the companhia
	 */
	public Companhia getCompanhia() {
		return companhia;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atraso == null) ? 0 : atraso.hashCode());
		result = prime * result + ((aviao == null) ? 0 : aviao.hashCode());
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((prevista == null) ? 0 : prevista.hashCode());
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
		Voo other = (Voo) obj;
		if (atraso == null) {
			if (other.atraso != null)
				return false;
		} else if (!atraso.equals(other.atraso))
			return false;
		if (aviao == null) {
			if (other.aviao != null)
				return false;
		} else if (!aviao.equals(other.aviao))
			return false;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (prevista == null) {
			if (other.prevista != null)
				return false;
		} else if (!prevista.equals(other.prevista))
			return false;
		return true;
	}
	
	@Override
	public String toString () {
		return hora.toString() + "\t" + aviao + "\t" + companhia.toString() + "\t" + origem 
				 + (prevista.equals("") ? "\n" : "\t" + atraso.toString() + "\t" + "Previsto: "
				 +	prevista + "\n");
	}

}
