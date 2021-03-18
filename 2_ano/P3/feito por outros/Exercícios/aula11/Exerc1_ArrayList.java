package aula11;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Exerc1_ArrayList {
	public static void main(String[] args) {
		ArrayList<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Bebé no Vector "+i,1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		
		printSet(vp.iterator());		
		
		ArrayList<Pessoa> lp = new ArrayList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		ArrayList<Figura> figList = new ArrayList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Rectangulo(1,2, 2,5));
		
		printSet(figList.iterator());
		
		System.out.println("Soma da Area de Lista de Figuras: " + sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		ArrayList< Rectangulo > quadList = new ArrayList<Rectangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Rectangulo(1,2, 2,5));
		
		System.out.println("Soma da Area de Lista de Quadrados: " +	sumArea(quadList));
	}
	
	public static double sumArea(ArrayList<? extends Figura> obj) {
		Iterator<? extends Figura> itr = obj.iterator();
		double soma = 0;
		while (itr.hasNext()) {
			soma = soma + itr.next().area();
			return soma;
		}
		return soma;
	}
	
	public static void printSet(Iterator<?> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}