package aula05;



public class Data {
	
	//ATRIBUTOS
	private int dia, mes, ano;
	
	//CONSTRUTOR
	public Data() //CRIA UMA DATA POR DEFEITO
	{
		ano = 2000;
		mes = 1;
		dia = 1;
	}
	
	//CONSTRUTOR
	public Data (int d, int m, int a)
	{
		dia=d;
		mes=m;
		ano=a;
	}
	
	public Data(String s)
	{ 
		String d="",m="",a="";
		int i=0;
		while(s.charAt(i)!='/')
		{ 
			d = d + s.charAt(i);
			i++;
		}
		i++;
		while(s.charAt(i)!='/')
		{
			m = m + s.charAt(i);
			i++;
		}
		i++;
		while(i != s.length())
		{ 
			a = a + s.charAt(i);
			i++;
		}
		i++;
		
	dia = Integer.parseInt(d);
	mes = Integer.parseInt(m);
	ano = Integer.parseInt(a);

	}
	
	public int getDia()
	{
		return dia;
	}
	public int getMes()
	{
		return mes;
	}
	public int getAno()
	{
		return ano;
	}
	
	public static boolean eBissexto(int ano)
	{
		if (ano%4==0 && (ano%400==0 || ano%100!=0))
			return true;
		return false;
	}
	public static int diasMes(int m, int a)
	{
		if(m==2)
			if (eBissexto(a))
				return 29;
			else
				return 28;
		if(m==11 || m==4 || m==6 || m==9)
			return 30;
		return 31;
	}
	public static boolean eValida(int dia, int mes, int ano)
	{
		if (ano<0)
			return false;
		if (mes<1 || mes>12)
			return false;
		if (dia<1)
			return false;
		if (dia>diasMes(mes, ano))
			return false;
		return true;
	}
	
	public String dataImp() {
		return dia + "-" + mes + "-" + ano;
	}
	
	
	
	

	
}
