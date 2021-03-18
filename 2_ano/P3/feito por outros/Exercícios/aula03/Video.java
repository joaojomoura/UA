package aula03;

public class Video {
	
	private static int ID=-1;
	private String titulo;
	private String categoria;
	private String idade;
	private int checkin, checkout, nCopias, rating;
	private int ratingT =0;
	private int nR = 0;
	private double ratingM;
	public Data[] dataAl;
	public Data[] dataDev;
	public String[] nomeCliente;
	
	public Video(String titulo, String categoria, String idade, int copias){ 
		
		this.titulo=titulo;
		this.categoria = categoria;
		this.idade = idade;
		checkin = copias;
		nCopias = copias;
		checkout = 0;
		ID++;
		dataAl = new Data[copias];
		dataDev = new Data[copias];
		nomeCliente = new String[copias];
		
		
	}

	
	
	public static int getID()
	{ 
		return ID;
		
	}
	
	public void emprestimo(String nome)
	{ 
		dataAl[checkout] = new Data();
		nomeCliente[checkout] = nome;
		checkin--;
		checkout++;
		
		
		
		
	}
	
	public void devolucao(int r)
	{ 
		dataDev[dataDev.length-checkin-1]=new Data();
		checkin++;
		checkout--;
		nomeCliente[checkout]= "";
		rating = r;
		ratingTotal(r);
		nR++;
		ratingMedio();
		
	}
	
	public boolean disponibilidade()
	{ 
		return checkin != 0;
		
	}
	
	public String getTitulo()
	{ 
		return titulo;
		
		
	}
	
	public String getCategoria()
	{  
		return categoria;
		
	}
	public String getIdade()
	{ 
		return idade;
		
		
	}
	
	public String toString()
	{ 
		return titulo + " | " + categoria + " | " + idade + " | " + checkin + " copias existentes para aluguer";
		
		
	}
	
	public static void decId()
	{ 
		ID--;
		
		
	}
	
	public boolean emprestado()
	{ 
		return checkin!=nCopias;
		
	}
	
	public int getCheckin()
	{ 
		return checkin;
		
	}
	
	public static boolean validaCat(String x)
	{ 
		x = x.toLowerCase();
		String cat = "terror acção comédia infantil drama aventura";
		
		if(cat.indexOf(x)==-1)
			return false;
		
		if(x.length()<5)
			return false;
		
		return true;
		
		
	}
	public static boolean validaIda(String x)
	{ 
		x = x.toLowerCase();
		String ida = "todos m6 m12 m16 m18";
		
		if(ida.indexOf(x)==-1)
			return false;
		
		if(x.length()<2)
			return false;
		
		return true;
		
		
	}
	
	private void ratingTotal(int r)
	{ 
		ratingT =ratingT + r;
		
	}
	
	private void ratingMedio()
	{ 
		
		ratingM=ratingT/nR;
	}
	
	public static boolean validaRating(int r)
	{ 
		if(r>10 || r<=0)
			return false;
		return true;
		
		
	}
	
	public int getRatingT()
	{ 
		return ratingT;
		
	}
	
	public double getRatingM()
	{ 
		return ratingM;
		
	}
	
	public int getLastRating()
	{ 
		return rating;
	}
	


}
