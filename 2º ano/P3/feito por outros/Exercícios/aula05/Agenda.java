package aula05;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
	
	public class Agenda {
		//ATRIBUTOS
		private Pessoa[] p = new Pessoa[100]; 
		private int maxPessoas = 100; //NUMERO MAXIMO DE REGISTOS
		private int np = 0;  //NUMERO DE REGISTOS REALIZADOS
		final static Scanner s = new Scanner(System.in);
		private String nomeFile;
		
		public void inserir(String nome, int BI, Data dataNasc) {
			assert !isFull();
	
			p[np] = new Pessoa(nome, BI, dataNasc);
			np++;
		}
		

		
	
		
		
		 
		public boolean isFull() {
			return ((maxPessoas - 1) == np);
		}
		
		
		
		public void imprime() {
			String ret = "";
	
			for (int i = 0; i < np; i++)
				ret = ret + "\n" + p[i].dados();
	
			System.out.println(ret);
		}
		
		
		public void apagar(String nome) {
			assert !isFull();
	
			for (int i = 0; i < np; i++) {
				if (p[i].getNome().equals(nome)) {
					for (int j = i; j < np - 1; j++)
						p[j] = p[j + 1];
					p[np] = null;
					np--;
				}
			}
		}
		
		public void ordenaNome() {
			for (int i = 0; i < np; i++) {
				for (int j = 0; j < np - i - 1; j++) {
					if (p[j].getNome().compareTo(p[j + 1].getNome()) > 0) {
						permuta(j, j + 1);
					}
				}
			}
		}
	
		public void ordenaBI() {
			for (int i = 0; i < np; i++) {
				for (int j = 0; j < np - i - 1; j++) {
					if (p[j].getBI() > p[j + 1].getBI()) {
						permuta(j, j + 1);
					}
				}
			}
		}
	
		private void permuta(int i, int j) {
			Pessoa temp = p[i];
			p[i] = p[j];
			p[j] = temp;
		}
		
		
		
		
		
		
		//*****LOAD*****
		
		public void load() throws IOException{
			System.out.println("Insira nome da agenda a carregar: ");
			nomeFile=s.nextLine();
			
			File f = new File(nomeFile);
			//save PrintWriter s1 = new PrintWriter(f);
			Scanner sf = new Scanner(f);
			
			String tipo=sf.nextLine();
			
			if(tipo.equalsIgnoreCase("vCard"))
			{ 



				while(sf.hasNextLine())
				{ 
					
					String temp = sf.nextLine();
					String nome="";
					String BI="";
					String d="";
					int i=1;
					while(temp.charAt(i)!='#')
					{ 
						nome = nome + temp.charAt(i);
						i++;
					}
					i++;
					while(temp.charAt(i)!='#')
					{ 
						BI = BI + temp.charAt(i);
						i++;
					}
					i++;
					while(i!=temp.length())
					{ 
						d = d + temp.charAt(i);
						i++;
					}
					
					inserir(nome,Integer.parseInt(BI), new Data(d));

				}
			}
				
			if(tipo.equalsIgnoreCase("Nokia"))
			{ 
				
				
				while(sf.hasNextLine())
				{ 
					inserir(sf.nextLine(),Integer.parseInt(sf.nextLine()), new Data(sf.nextLine()));

					
				}
			}
			
			if(tipo.equalsIgnoreCase("CSV"))
			{ 
				
				sf.nextLine();
				
				String temp = sf.nextLine();
				String nome="";
				String BI="";
				String d="";
				int i=1;
				while(temp.charAt(i)!='\t')
				{ 
					nome = nome + temp.charAt(i);
					i++;
				}
				i++;
				while(temp.charAt(i)!='\t')
				{ 
					BI = BI + temp.charAt(i);
					i++;
				}
				i++;
				while(temp.charAt(i)!='\t')
				{ 
					d = d + temp.charAt(i);
					i++;
				}
				
				inserir(nome,Integer.parseInt(BI), new Data(d));

			}
			
		}
		
		
		//*****SAVE*****
		
		public void save() throws IOException
		{ 
			File fi = new File(nomeFile);
			//save PrintWriter s1 = new PrintWriter(f);
			Scanner sf = new Scanner(fi);
			
			String x=sf.nextLine();
			
			if(x.equalsIgnoreCase("vCard"))
			{
				File a = new File("agenda2.txt");
				PrintWriter f = new PrintWriter(a);
				f.println("vCard");
				for(int i = 0; i< np; i++)
				{ 
				
				f.println("#"+p[i].getNome() + "#" + p[i].getBI() + "#" + p[i].getData());
			
				}
				f.close();
			}
			if(x.equalsIgnoreCase("Nokia"))
			{ 
				File a = new File("agenda1.txt");
				PrintWriter f = new PrintWriter(a);
				f.println("Nokia");
				for(int i = 0; i< np; i++)
				{ 
				
				f.println("\n"+p[i].getNome() + "\n" + p[i].getBI() + "\n" + p[i].getData());
			
				}
				f.close();
				
				
			}
			if(x.equalsIgnoreCase("CSV"))
			{ 
				File a = new File("agenda3.txt");
				PrintWriter f = new PrintWriter(a);
				f.println("CSV");
				for(int i = 0; i< np; i++)
				{ 
				
				f.println("\t"+p[i].getNome() + "\t" + p[i].getBI() + "\t" + p[i].getData());
			
				}
				f.close();
				
				
			}
			
		}
		
	
	}
