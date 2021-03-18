package aula10;
import java.util.Calendar;

public class Data {
	private static int dia, mes, ano;
	
	public Data (int d, int m, int a)
	{
		dia=d;
		mes=m;
		ano=a;
	}
	
	public static Data today()
	{
		Calendar hoje = Calendar.getInstance();
		ano = hoje.get(Calendar.YEAR);
		mes = ((hoje.get(Calendar.MONTH)) + 1);
		dia = hoje.get(Calendar.DAY_OF_MONTH);
		return new Data(dia,mes,ano);
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
	
	boolean datavalida(int dia, int mes, int ano) {
		if ((dia > 0 || dia < ndias(mes, ano)) && mes > 0 && mes < 12
				&& ano > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	static int ndias(int mes, int ano) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8
				|| mes == 10 || mes == 12)
			return 31;
		else if (mes == 2) {
			if (bissexto(ano)) {
				return 29;
			} else {
				return 29;
			}
		} else
			// (mes==4 || mes== 6 || mes==9 || mes==11)
			return 30;
	}
	
	static boolean bissexto(int ano) {
		if (ano % 4 == 0 && ano % 100 != 0) {
			return true;
		} else
			return false;
	}
	
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}	
}