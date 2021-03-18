//Aula 8 Ex 3

import java.util.Scanner;
import java.lang.Math;

// Complete o programa
public class Ex8_3 {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    // Cria um registo de estatisticas:
    Statistics xstat = new Statistics();
    
    // Enquanto houver um valor para ler:
    while (sc.hasNextDouble()) {
      // Lê um valor:
      double x = sc.nextDouble();
      // Atualiza o registo de estatisticas:
      updateStats(xstat, x);
    }
    
    // Escreve resultados:
    System.out.printf("numero de valores = %d\n", xstat.num);
    System.out.printf("soma dos valores = %f\n", xstat.sum);
    System.out.printf("soma dos quadrados = %f\n", xstat.sum2);
    if (xstat.num > 0) {
      System.out.printf("min = %f\n", xstat.min);
      System.out.printf("max = %f\n", xstat.max);
      System.out.printf("média = %f\n", mean(xstat));
      System.out.printf("variancia = %f\n", variance(xstat));
    } else {
      System.out.printf("Lista vazia!");
    }
  }


  //funtion to update the stats 
  public static Statistics updateStats(Statistics stat, double x) {

    stat.num++;                             //counts the doubles given by the user
    stat.sum = stat.sum + x;                //sum of all the doubles
    stat.sum2 = stat.sum2 + Math.pow(x,2);  //sum of all the square doubles
    
    //check which of the numbers is higher or lower
    if (stat.max < x)
      stat.max = x;
    if (stat.min > x)
      stat.min = x;
    
    return stat;                            //return the stats

  }

  // function to discover the mean
  public static double mean (Statistics stat) {

    return stat.sum / stat.num; //media = soma / total de elementos
  }

  //function to discover the variance
  public static double variance(Statistics stat) {

    return ((stat.sum2 - (Math.pow(stat.sum,2)/stat.num))/(stat.num-1));
  }
  
}

// classe Statistics
class Statistics {

  //variaveis
  double max, min = Double.MAX_VALUE, sum, sum2; 
  int num;
}