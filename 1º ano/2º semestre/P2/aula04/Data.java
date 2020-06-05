import static java.lang.System.*;
import java.util.Calendar;
import java.util.EventListener;

public class Data {
  private int dia, mes, ano;

  /** Inicia esta data com o dia de hoje. */
  public Data() {
    // Aqui usamos a classe Calendar da biblioteca standard para obter a data atual.
    Calendar today = Calendar.getInstance();
    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
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
  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
    assert dataValida(dia, mes, ano);
    this.ano = ano;
    this.mes = mes;
    this.dia = dia;
  }

  /**Verificar se String data é valida */
  public Data(String data) {
    
    String [] arrayDate = data.split("-");
    if(arrayDate.length != 3){
      err.println("Data invalida");
      exit(1);
    }
    int ano = Integer.parseInt(arrayDate[0]);
    int mes = Integer.parseInt(arrayDate[1]);
    int dia = Integer.parseInt(arrayDate[2]);

    if(dataValida(dia, mes, ano)== false) {
      err.println("Data invalida");
      exit(1);
    }
    else {
      this.ano = ano;
      this.mes = mes;
      this.dia = dia;
    }
      

  }

  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }

  // Crie métodos para obter o dia, mes e ano da data.
  //...

  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
    assert mes > 0 && mes < 13;
    assert ano > 0;
    switch(mes) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        return diasMesComum[mes-1];
        

      case 2:
        if(bissexto(ano))
          return 29;
        else
          return diasMesComum[1];
      
      default:
          return diasMesComum[mes-1];
          
    }
    
  }

  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
    switch(mes) {
      case 1:
        return "Janeiro";
      case 2:
        return "Fevereiro";
      case 3:
        return "Março";
      case 4:
        return "Abril";
      case 5:
        return "Maio";
      case 6:
        return "Junho";
      case 7:
        return "Julho";
      case 8:
        return "Agosto";
      case 9:
        return "Setembro";
      case 10:
        return "Outubro";
      case 11:
        return "Novembro";
      default:
        return "Dezembro";
    }
  }


  /** Devolve esta data por extenso. */
  public String extenso() {
    
    return String.format("%02d de %s de %04d", dia,mesExtenso(),ano);
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
    if(mes <= 0 || mes > 12)
    return false;
    if(dia <= 0 || (bissexto(ano) == false && dia > diasMesComum[mes-1]))
      return false;
    if(ano < 0)
      return false;
    return true;
  }


  public void seguinte() {
    if(bissexto(ano))
      diasMesComum[1] = 29;
    
    if(dia == diasMesComum[mes-1] && mes < 12){
      dia = 1;
      mes++;
    }

    else if(dia == diasMesComum[11] && mes == 12){
      dia = 1;
      mes = 1;
      ano ++;
    }
    else
      dia++;

    assert dataValida(dia, mes, ano);
  }

  public int compareTo (Data date) {
    
    String str = this.toString();
    String str_2 = date.toString();

    return str.compareTo(str_2);
  }



}

