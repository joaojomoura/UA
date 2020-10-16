package aula02;


public class Cliente {
	private static int ID=-1; //começa a -1 porque o ID inicial é 0
	private Data dataIns;
	private Estudante a;
	private Funcionario b;
	private String tipo;
	private Video[] videoAl; 
	private int nAl = 0;
	private String cab;
	
	
	public Cliente(Estudante a, Data dataInsc,int copias)
	{ 
		this.a = a;
		dataIns = dataInsc;
		tipo = "Estudante";
		cab = cab();
		videoAl = new Video[copias];
		ID++;
	
	}
	
	public Cliente(Funcionario b, Data dataInsc,int copias){
		
		this.b=b;
		dataIns = dataInsc;
		tipo = "Funcionario";
		cab = cab();
		videoAl = new Video[copias];
		ID++;
		
	}
	
	public static int getID()
	{ 
		return ID;
	}
	
	public String getTipo()
	{ 
		return tipo;
		
	}
	
	public Data dataIns()
	{
		return dataIns;
	}
	
	public String toString()
	{ 
		if(tipo.equals("Estudante"))
		{ 
			return a.toString() + " | Data Inscrição: " +a.getData();
			
		}
		else
			return b.toString() + " | Data Inscrição: " +b.getData();
		
	}
	
	public boolean poderAlugar()
	{ 
		for(int i = 0; i< videoAl.length; i++)
		{ 
			if(videoAl[i]==null)
				return true;
			
		}
		return false;
	}
	
	public void alugar(Video a)
	{ 	

		videoAl[nAl]=a;
		nAl++;
		
		
	}
	
	public String getName()
	{ 
		if(tipo.equals("Estudante"))
		{ 
			return a.getNome();
			
		}
		else
			return b.getNome();	
		
	}
	public String cab()
	{ 
		String x =" ---------------------------------------------- \n" +
				  "|                                              | \n" +"|";
		for(int i = 0;i<23-(getName().length()/2);i++)
			x = x + " ";
		x = x + getName();
		for(int i = 0;i<23-(getName().length()/2);i++)
			x = x + " ";
		x = x +"| \n"+
				  "|                                              | \n" +
				  " ---------------------------------------------- \n" +
				  "|                    Filme                     |\n" +
				  " ----------------------------------------------\n";
				  

		return x;
	}
	
	public void historico()
	{ 
		if(nAl>0)
			for(int i= nAl-1; i< videoAl.length; i++)
			{
				if(videoAl[i]!=null)
				{
					int x;
					if(videoAl[i].getTitulo().length()%2==0)
						x = 22;
					else
						x = 23;
					cab = cab + "|";
					for(int k=0;k<23-(videoAl[i].getTitulo().length()/2);k++)
						cab = cab +" ";
						
					cab = cab + videoAl[i].getTitulo();
					for(int k=0;k<x-(videoAl[i].getTitulo().length()/2);k++)
						cab = cab +" ";
						
					cab = cab +"| \n";
				}
		}

			

		
	}
	
	public String getHistorico()
	{ 
		return cab;
		
	}
	
	public boolean semVideoAlugado()
	{ 
		for(int i = 0; i<videoAl.length;i++)
		{ 
			if(videoAl[i]!= null)
				return false;
			
		}
		return true;
	}
	
	public boolean videoAlugado(String x)
	{ 
		for(int i = 0; i<videoAl.length;i++)
		{ 
			if(videoAl[i]!= null)
			{ 
				if(videoAl[i].getTitulo().equals(x))
					return true;
			
			}
		}
		return false;
	}
	
	public void devolucao(String x)
	{ 
		for(int i=0;i<videoAl.length;i++)
		{ 
			if(videoAl[i]!=null)
			{
				if(videoAl[i].getTitulo().equals(x))
				{
					videoAl[i]=null;
					nAl--;
					break;
				}
			}

		}
		
	}
	
	public Boolean filmeJaAlugado(String x)
	{ 
		for(int i = 0; i<videoAl.length; i++)
		{ 
			if(videoAl[i]!= null)
			{ 
				if(videoAl[i].getTitulo().equals(x))
				{ 
					return true;
					
				}
				
			}
			
		}
		
		return false;
	}

	
	
	
	
	

}
