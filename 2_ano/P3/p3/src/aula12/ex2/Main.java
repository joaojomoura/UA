package aula12.ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import aula3.ex2.Circulo;
import aula3.ex2.Figura;
import aula3.ex2.Quadrado;
import aula3.ex2.Rectangulo;

public class Main
{
	public static void main(String[] args)
	{
		List<Figura> figList = new ArrayList<>();
		figList.add(new Circulo (1,3, 1));		
		figList.add(new Quadrado(3,4, 2));		
		figList.add(new Rectangulo(1,2, 2,5));	
		figList.add(new Quadrado(1));			
		figList.add(new Quadrado(2));			
		figList.add(new Rectangulo(1,1));		
		System.out.println(maiorFiguraJ8(figList).toString());
		System.out.println(maiorFiguraJ8P(figList).toString());
		System.out.println(areaTotalJ8(figList));				
		System.out.println(areaTotalJ8(figList, "Quadrado"));	
	}
	
	public static Figura maiorFiguraJ8(List<Figura> figs)
	{
		return figs.stream().max(Comparator.naturalOrder()).get();
	}
	
	public static Figura maiorFiguraJ8P(List<Figura> figs)
	{
		return figs.stream().max(new Comparator<Figura>()
				{
					@Override
					public int compare(Figura o1, Figura o2)
					{
						if (o1.perimetro() > o2.perimetro())
							return 1;
						else if (o1.perimetro() < o2.perimetro())
							return -1;
						else
							return 0;
					}
				}).get();
	}
	
	public static double areaTotalJ8(List<Figura> figs)
	{
		return figs.stream().mapToDouble(f -> f.area()).sum();
	}
	
	public static double areaTotalJ8(List<Figura> figs, String subtipoNome)
	{
		return figs.stream().filter(f -> f.getClass().getSimpleName().equals(subtipoNome)).mapToDouble(f -> f.area()).sum();
	}
}
