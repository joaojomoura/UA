/**
 * 
 */
package aula3.ex2;

/**
 * @author João Moura
 *
 */
public class Rectangulo extends Figura{
	
	//atributos
	private double largura, comprimento;
	
	
	//Contrutores
	public Rectangulo(double l, double c, Ponto centro) {
		super(centro);
		largura = l;
		comprimento = c;
	}
	
	public Rectangulo(double l, double c) {
		this(l,c,new Ponto());
	}
	
	public Rectangulo(double l, double c, double x, double y) {
		this(l,c,new Ponto(x,y));
	}
	
	public Rectangulo(Rectangulo r) {
		this(r.largura,r.comprimento,r.getCentro());
	}

	//getters
	/**
	 * @return the largura
	 */
	public double getLargura() {
		return largura;
	}

	/**
	 * @return the comprimento
	 */
	public double getComprimento() {
		return comprimento;
	}
	
	
	//Metodos
	@Override
	public String toString()
	{
		return "Retangulo de comprimento " + comprimento + ", largura " + largura + " e centro " + this.getCentro();
	}
	
	@Override
	public double area()
	{
		return comprimento * largura;
	}
	
	@Override
	public double perimetro()
	{
		return 2 * comprimento + 2 * largura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(comprimento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(largura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
			return false;
		if (Double.doubleToLongBits(largura) != Double.doubleToLongBits(other.largura))
			return false;
		return true;
	}
	
	

}
