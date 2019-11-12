import java.util.Scanner;
import java.io.*;

public class ex12_1 {
    public static Scanner sc = new Scanner (System.in);
    public static void main (String [] args) throws IOException {
        //variables
        String file = new String();
        Data [] station = new Data [31];
        int n = 0, choice = 0;
        CalTemp calc = new CalTemp();

        //menu
        
        do {
            menu();
            System.out.print("opçao: ");
            choice = read_int();
            switch(choice) {
                case 1: 
                    file = file_name();
                    n = read_file(station, file);
                    break;
                case 2:
                    n = add(station, n);
                    break;
                case 3:
                    print(station, n);
                    break;
                case 4:
                    bubblesort(station,n,1);
                    print(station, n);
                    break;
                case 5:
                    bubblesort(station,n,2);
                    print(station, n);
                    break;
                case 6:
                    media(station, calc, n);
                    break;
                case 7:
                    max_min(station, calc, n, 1);
                    max_min(station, calc, n, 2);
                    break;
                case 8:
                    histograma(station, n);
                    break;
                case 9:
                    System.out.println("fim do programa");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }    
        }while(choice != 9);
        
        
        
        
        
        
        
        
    }

    // ask the user for a file name
    public static String file_name () {
        String file;
        do {
            System.out.print("Nome do ficheiro: ");
            file = sc.nextLine();
        } while(file.isEmpty());    //repeat while he gives no string
        return file;
    }
    //read the file given by user
    public static int read_file(Data [] station,String file) throws IOException{
        int n = 0;
        File f = new File(file);
        Scanner readf = new Scanner (f);

        while(readf.hasNext() && n < station.length) { // while there are numbers to read
            station [n] = new Data();
            station[n].temp = readf.nextInt();
            station[n].hum = readf.nextInt();
            n++;
        }
        readf.close();
        return n;
    }
    //print the numbers
    public static void print (Data [] station,int n) {
        System.out.println("Medidas: ");
        for(int i = 0; i < n; i++) {
            System.out.printf("%d-Temperatura = %d Humidade = %d%n",i,station[i].temp,station[i].hum);
        }
    }
    // add a new temp and hum
    public static int add (Data [] station, int n) {
        int temp = 0, hum = 0;
        
        if (n < station.length) { //if there's no more than 31 numbers, it can be added another measure
            
            do {
                System.out.print("Temperatura: ");
                temp = sc.nextInt();    
            }while(temp < -10 || temp > 40);
            do {
                System.out.print("Humidade: ");
                hum = sc.nextInt();    
            }while(hum < 0 || hum > 100);
            station[n] = new Data();
            station [n].hum = hum;
            station [n].temp = temp;
            n++;

            return n;
        }
        if(n == station.length)
            System.out.println("Tamanho maximo atingido.");
        return n;
    }
    //troca
    public static void swap (Data [] station,int i, int j) {
        Data tmp  = new Data();
        tmp = station[i];
        station[i] = station [j];
        station[j] = tmp;
    }
    //bubblesort 
    public static void bubblesort (Data []station, int n,int choice) {
        boolean troca;
        int nOrd = 0;
        do {
            troca = false;
            for(int i = 0; i < n - 1 - nOrd;i++){
                switch(choice){
                    case 1: //ordem crescente por temperatura
                        if(station[i].temp > station[i+1].temp){    
                            swap(station, i, i+1);
                            troca = true;
                        }
                        break;
                    case 2: //ordem decrescente por humidade
                        if(station[i].hum < station[i+1].hum){
                            swap(station,i,i+1);
                            troca = true;
                        }
                        break;
                }
            }
            nOrd++; //reduces the comparison made 
        }while(troca);
    }

    //medium value from temp and hum
    public static void media (Data [] station, CalTemp calc, int n) {
        int sum_t = 0, sum_h = 0;
        for(int i = 0; i < n; i++) {
            sum_t += station[i].temp;
            sum_h += station[i].hum;
        }
        calc.media_h = (double)sum_h/n;
        calc.media_t = (double)sum_t/n;
        System.out.printf("%nMedia de Temperatura: %.2f%nMedia Humidade: %.2f%n",calc.media_t,calc.media_h);
    }

    //max and min temp/hum
    public static void max_min (Data []station, CalTemp calc, int n, int choice) {
       //Max temp and hum
        if(choice == 1) {
            for(int i = 0; i < n; i++) {
                if(calc.max_t < station[i].temp)
                    calc.max_t = station[i].temp;
                if(calc.max_h < station[i].hum)
                    calc.max_h = station[i].hum;
            }
            System.out.printf("%nValor maximo Temperatura: %d%nValor maximo humidade: %d",calc.max_t,calc.max_h);
        }
        // Min temp and hum
        else {
            for(int i = 0; i < n; i++) {
                if(calc.min_t > station[i].temp)
                    calc.min_t = station[i].temp;
                if(calc.min_h > station[i].hum)
                    calc.min_h = station[i].hum;
            }
            System.out.printf("%nValor minimo Temperatura: %d%nValor minimo humidade: %d%n",calc.min_t,calc.min_h);
        }
    }

    //histograma
    public static void histograma (Data [] station, int n) {
        System.out.println("Histograma da temperatura");
        System.out.println("------------------------");
        for(int i = -10; i <= 40; i++) {
            System.out.printf("%-4d|  ",i);
            for(int j = 0; j < n; j++) {
                if(i == station[j].temp)
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Histograma da Humidade");
        System.out.println("------------------------");
        for(int i = 0; i <= 100; i++) {
            System.out.printf("%-4d|  ",i);
            for(int j = 0; j < n; j++) {
                if(i == station[j].hum)
                    System.out.print("*");
            }
            System.out.println();
        }

    }
    //Menu
    public static void menu () {
        System.out.println("Estação meteorológica:");
        System.out.println("1 - Ler ficheiro de dados");
        System.out.println("2 - Acrescentar medida");
        System.out.println("3 - Listar valores de temperatura e humidade");
        System.out.println("4 - Listar medidas ordenadas por valor de temperatura");
        System.out.println("5 - Listar medidas ordenadas por valor de humidade");
        System.out.println("6 - Calcular valores médios de temperatura e humidade");
        System.out.println("7 - Calcular valores máximos e mínimos de temperatura e humidade");
        System.out.println("8 - Calcular histograma das temperaturas e humidade");
        System.out.println("9 - Terminar o programa");
    }
    //Read int
    public static int read_int() {
        int num = 0;
        num = sc.nextInt();
        return num;
    } 
    


}

class Data {
    int temp;
    int hum;
}
class CalTemp {
    int max_t = Integer.MIN_VALUE, min_t = Integer.MAX_VALUE;
    int max_h = Integer.MIN_VALUE, min_h = Integer.MAX_VALUE;
    double media_t,media_h;
}