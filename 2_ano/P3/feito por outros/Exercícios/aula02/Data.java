package aula02;



import java.util.Calendar;
//Class Data usada em P2
public class Data {
	private int dia, mes, ano;

	// Data introduzida pelo utilizador
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	// Data actual
	public Data() {
		Calendar hoje = Calendar.getInstance();
		ano = hoje.get(Calendar.YEAR);
		mes = ((hoje.get(Calendar.MONTH)) + 1);
		dia = hoje.get(Calendar.DAY_OF_MONTH);
	}

	public String dataImp() {
		String s = dia + "-" + mes + "-" + ano;
		return s;
	}

	static boolean bissexto(int ano) {
		if (ano % 4 == 0 && ano % 100 != 0) {
			return true;
		} else
			return false;
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

	boolean datavalida() {
		if ((dia > 0 || dia < ndias(mes, ano)) && mes > 0 && mes < 12
				&& ano > 0) {
			return true;
		} else {
			return false;
		}
	}

	boolean datavalida(int dia, int mes, int ano) {
		if ((dia > 0 || dia < ndias(mes, ano)) && mes > 0 && mes < 12
				&& ano > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int dia() {
		return dia;
	}

	public int mes() {
		return mes;
	}

	public int ano() {
		return ano;
	}

	public String nomeMes(int mes) {
		String [] meses = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho","Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		return meses[mes];
	}

	public String dataExtenso(int dia, int mes, int ano) {
		return dia + " de " + nomeMes(mes) + " de " + ano;
	}

	public void vaiParaAmanha(int dia, int mes, int ano) {
		if (dia == 30 && ndias(mes, ano) == 30) {
			dia = 1;
			if (mes == 12) {
				mes = 1;
				ano++;
			} else
				mes++;
		} else if (dia == 31 && ndias(mes, ano) == 31) {
			dia = 1;
			if (mes == 12) {
				mes = 1;
				ano++;
			} else {
				mes++;
			}
		} else if ((dia == 28 && mes == 2) || (dia == 29 && mes == 2)) {
			dia = 1;
			mes++;
		} else {
			dia++;
		}
	}

	public void vaiParaOntem(int dia, int mes, int ano) {
		if (dia == 1 && ndias(mes - 1, ano) == 30) {
			dia = 30;
			if (mes == 1) {
				mes = 12;
				ano--;
			} else
				mes--;
		} else if (dia == 1 && ndias(mes - 1, ano) == 31) {
			dia = 31;
			if (mes == 1) {
				mes = 12;
				ano--;
			} else {
				mes--;
			}
		} else if (dia == 1 && mes == 2) {
			dia = 31;
			mes = 1;
		} else {
			dia--;
		}

	}

	 public String toString(){
		  return dataExtenso(dia,mes,ano);
		 }
}
