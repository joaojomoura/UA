package videoclube;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Data {

	private int dia;
	private int mes;
	private int ano;
 
	public Data()
	{
		GregorianCalendar gregorianCalendar=new GregorianCalendar();
		this.dia=gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH);
		this.mes=gregorianCalendar.get(GregorianCalendar.MONTH);
		this.ano=gregorianCalendar.get(GregorianCalendar.YEAR);
	}
	
	public Data(int idia, int imes, int iano)
	{
		this.dia=idia;
		this.mes=imes;
		this.ano=iano;
	}
	
	public int getDia()
	{
		return this.dia;
	}
	
	public int getMes()
	{
		return this.mes;
	}
	
	public int getAno()
	{
		return this.ano;
	}
	
	public void setDia(int idia)
	{
		if(idia>=1 && idia<=diasDoMes())
		{
			this.dia=idia;
		}
	}
	
	public void setMes(int imes)
	{
		if(imes>0 && imes<=12)
		{
			this.mes=imes;
		
		}
	}
	
	public void setAno(int iano)
	{
		if(iano>0)
		{
			this.ano=iano;
		}
	}
	
	public void lerData (){
		Scanner scan=new Scanner (System.in);
		
		do{
			
			System.out.println("Dia do mes: ");
			this.dia=scan.nextInt();
			
			System.out.println("Mes: ");
			this.mes=scan.nextInt();
			
			System.out.println("Ano: ");
			this.ano=scan.nextInt();
			
		}while(!isValid());
	}
	
	public boolean isValid (){
		if (this.ano<1)
			return false;
		if (this.mes<1 || this.mes >12)
			return false;
	    if (this.dia>diasDoMes () || this.dia<1)
	    	return false;
	    return true;
	}

	private int diasDoMes() {
		switch (this.mes){
		   case 1:
		   case 3:
		   case 5:
		   case 7:
		   case 8:
		   case 10:
		   case 12:return 31;
		   case 4:
		   case 6:
		   case 9:
		   case 11: return 30;
		   case 2:{
			   if (isBissexto())
				   return 29;
			   else
				   return 28;
		   }
		}
		return 0;
	}

	private boolean isBissexto() {
		if (this.ano % 4==0)
			return true;
		return false;
	}
	
	public String toString(){
		return this.dia+"-"+this.mes+"-"+this.ano;
	}
}
