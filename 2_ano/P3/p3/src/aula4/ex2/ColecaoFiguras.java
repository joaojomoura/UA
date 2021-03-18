/**
 * 
 */
package aula4.ex2;
import aula3.ex2.*;

/**
 * @author João Moura
 *
 */
public class ColecaoFiguras {
	
	private double maxArea;
	private double somaArea;
	private Figura [] coleccao;
	private int numFiguras;
	
	public ColecaoFiguras (double mA) {
		maxArea = mA;
		somaArea = 0;
		coleccao = new Figura [20];
		numFiguras = 0;
	}
	
	/**
	 * 
	 * @param f
	 * @return true se adicionar a figura
	 */
	public boolean addFigura (Figura f) {
		if(somaArea + f.area() > maxArea)
			return false;
		for(int i = 0; i < coleccao.length; i++)
			if(f.equals(coleccao[i]))
				return false;
		coleccao[numFiguras] = f;
		somaArea += f.area();
		numFiguras++;
		return true;
		
	}
	
	/**
	 * 
	 * @param f
	 * @return true se eliminar a figura
	 */
	public boolean delFigura(Figura f) {
		
		if(numFiguras == 0) {
			System.out.println("Lista Vazia");
			return false;
		}
		int i;
		for(i = 0; i < coleccao.length; i++) {
			if(coleccao[i].equals(f))
				break;
		}
		
		
		Figura [] tmp = new Figura [numFiguras-1];
		
		for(int j = 0, k = 0; k < numFiguras; k++) {
			if(k == i)
				continue;
			tmp [j++] = coleccao [k];
		}
		
		for (int j = 0; j < numFiguras-1; j++)
			coleccao[j] = tmp [j];
		numFiguras--;
		somaArea-=coleccao[i].area();
		return true;
	}
	
	/**
	 * 
	 * @return area total da lista
	 */
	public double areaTotal() {
		return somaArea;
	}
	
	/**
	 * 
	 * @return o array da lista de figuras
	 */
	public Figura [] getFiguras() {
		Figura [] newList = new Figura [numFiguras];
		for (int i = 0; i < numFiguras; i++) {
			newList[i] = coleccao[i];
		}
		return newList;
	}
	
	/**
	 * 
	 * @return o array com lista de centros das figuras
	 */
	public Ponto [] getCentros() {
		Ponto [] listaPontos = new Ponto [numFiguras];
		for(int i = 0; i < numFiguras; i++) {
			listaPontos[i] = coleccao[i].getCentro();
		}
		return listaPontos;
	}
	
	
	
	
	
	

}
