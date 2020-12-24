/**
 * 
 */
package aula7.ex1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.*;
import java.util.*;

/**
 * @author João Moura
 *
 */
public class ListadeVoos {
	/**
	 * Atributos
	 */
	private List <Voo> voos;
	private LerCompanhias companhias;
	
	/**
	 * 
	 * @param vtxt
	 * @param comptxt
	 * @throws IOException
	 * Recebe os ficheiros e coloca na lista voos toda a informacao de cada voo
	 */
	public ListadeVoos(String vtxt,String comptxt) throws IOException {
		companhias = new LerCompanhias(comptxt);
		
		Path file = Paths.get(vtxt);
		List <String> lines = Files.readAllLines(file);
		voos = new ArrayList <>();
		
		for (String line : lines) {
			if(line.equals("Hora\tVoo\tOrigem\tAtraso")) {
				
			}
			else {
				String [] tmp = line.split("\t");
				String comp = tmp[1].substring(0, 2);
				try {
					voos.add(new Voo(tmp[0],tmp[1],companhias.getCompanhia(comp),tmp[2],tmp[3]));
				}
				catch(NumberFormatException e){
					System.err.println("Hora mal formatada");
					
				}
				catch(ArrayIndexOutOfBoundsException e) {
					voos.add(new Voo(tmp[0], tmp[1], companhias.getCompanhia(comp) , tmp[2]));
				}
				catch (NullPointerException e){
					System.out.println(comp);
					System.err.println("Companhia nao registada");
				}
			}
		}	
	}
	
	public void printScreen() {
		System.out.println("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs");
		for (Voo voo : voos){
			try{
				System.out.print(voo.toString());
			}
			catch (NullPointerException e){;}
		}
	}
	
	public void printPaper() throws IOException {
		
		List<String> lines = new ArrayList<> ();
		Path file = Paths.get("Infopublico.txt");
		lines.add("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs\n");
		for (Voo v: voos) {
			try {
				lines.add(v.toString());
			}
			catch (NullPointerException e)
			{
				;
			}
		}
		Files.write(file, lines);
	}
	
	public void printDelayAverage()
	{
		Hashtable<Companhia, Integer> delays = new Hashtable<>();
		System.out.println("\n\n\nCompanhia\t\tAtraso médio");
		
		Companhia comps[] = companhias.getCompanhias();
		int sum, count;
		
		for (Companhia companhia : comps)
		{
			sum = 0;
			count = 0;
			for (Voo voo : voos)
			{
				try
				{
					if(voo.getCompanhia().equals(companhia))
					{
						sum += voo.getAtraso().getTempoEmMinutos();
						count++;
					}
				}
				catch (NullPointerException e)
				{;}
			}
			delays.put(companhia, sum/count);
		}
		
		for (Companhia companhia : comps)
		{
			System.out.println(companhia.toString() + "\t" + Hora.minutosEmHorasString(delays.get(companhia)));
		}
	}
	
	public void saveCity() throws IOException
	{
		Hashtable<String, Integer> origens = new Hashtable<>();
		List<String> lines = new ArrayList<>();
		int i;
		lines.add("Origem\tVoos\n");
		
		for (Voo voo : voos)
		{
			if (origens.containsKey(voo.getOrigem()))
			{
				origens.replace(voo.getOrigem(), origens.get(voo.getOrigem())+1);
			}
			else
			{
				origens.put(voo.getOrigem(), 1);
			}
		}
		
		String cities[] = (origens.keySet()).toArray(new String[origens.size()]);
		Iterator<Integer> iter = (origens.values()).iterator();
		int flys[] = new int[origens.size()];
		
		
		// put ints in array
		for(i = 0; i < flys.length; i++)
		{
			flys[i] = iter.next();
		}
		
		// do bubble sort for both
		boolean swap;
		String aux;
		do
		{
			swap = false;
			for(i = 0; i < flys.length -1; i++)
			{
				if (flys[i] < flys[i+1])
				{
					// swap city
					aux = cities[i];
					cities[i] = cities[i+1];
					cities[i+1] = aux;
					
					// swap city value
					flys[i] = flys[i] + flys[i+1];
					flys[i+1] = flys[i] - flys[i+1];
					flys[i] = flys[i] - flys[i+1];
					
					swap = true;
				}
			}
		}while(swap);
		
		for (i = 0; i < flys.length; i++)
		{
			lines.add(cities[i] + "\t" + flys[i] + "\n");
		}
		Path file = Paths.get("cidades.txt");
		Files.write(file, lines);
	}

	public void saveAllBin() throws IOException
	{
		RandomAccessFile file = new RandomAccessFile("Infopublico.bin", "rw");
		String flys = "";
		for (Voo voo : voos)
		{
			try
			{
				flys += voo.toString();
			}
			catch (NullPointerException e)
			{;}
		}
		file.write(flys.getBytes("UTF-8"));
		file.close();
	}
	
	public void readBin() throws IOException
	{
		RandomAccessFile file = new RandomAccessFile("Infopublico.bin", "rw");
		byte data[] = new byte[(int)file.length()];
		file.readFully(data);
		file.close();
		System.out.println(new String(data));
	}
	
	
	@Override
	public String toString()
	{
		String flys = "";
		for (Voo voo : voos)
		{
			flys += voo.toString();
		}
		return flys;
	}
	
	

}
