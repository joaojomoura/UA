/**
 * 
 */
package aula12.ex3;

/**
 * @author 
 *
 */
public class PratoVegetariano extends Prato {

	public PratoVegetariano(String n) {
		super(n);
	}

	@Override
	public boolean addIngrediente(Ingrediente e) {
		if(e == null) return false;
		if(e instanceof Vegetariano) return super.addIngrediente(e);
		return false;
		
	}
	
	

}
