/**
 * 
 */
package aula3.ex2;

/**
 * @author Joao Moura
 *
 */
public class Quadrado extends Rectangulo{
	
	public Quadrado(double l, Ponto c)
	{
		super(l, l, c);
	}
	
	public Quadrado(double l, int x, int y)
	{
		this(l, new Ponto(x, y));
	}
	
	public Quadrado(double l)
	{
		this(l, new Ponto(0,0));
	}
	
	public Quadrado(Quadrado q)
	{
		this(q.getLargura(), q.getCentro());
	}
	
	@Override
	public String toString()
	{
		return "Quadrado de lado " + this.getComprimento()  + " e centro " + this.getCentro();
	}

}
