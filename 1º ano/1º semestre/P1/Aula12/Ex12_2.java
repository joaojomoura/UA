import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Ex12_2 {
    public static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) {
        //variaveis
        Pilot pilotos [] = new Pilot [10];
        int n;

        n = pilot_read(pilotos);
        //print_decre(pilotos, n);
        //change_data(pilotos, n);
        // print_decre(pilotos, n);
        //n = remove_vehicle(pilotos, n);
        print_cre(pilotos, n);

    }
    //user given data for the pilots
    public static int pilot_read (Pilot [] pilotos) {
        int n = 0;
        do {
            pilotos[n] = new Pilot();
            System.out.print("Introduza o nome: ");
            pilotos[n].name = sc.nextLine();
            if(!(pilotos[n].name).isEmpty()){
                System.out.print("Introduza a matricula: ");
                pilotos[n].matricula = sc.nextLine();
                pilotos[n].number = n + 1;
            }
            n++;
        }while(!(pilotos[n-1].name).isEmpty() && n < pilotos.length); //stop if there's no name
        return n;
    }
    //print information decre by number
    public static void print_decre (Pilot [] pilotos, int n) {
        boolean troca;
        int nOrd = 0, name = 0;
        do {
            troca = false;
            for(int i = 0; i < n - 1 - nOrd; i++) {
                if(pilotos[i].number < pilotos[i+1].number) {
                    swap(pilotos,i,i+1);
                    troca = true;
                }
            }
            nOrd++;
        }while(troca);

        System.out.printf("%n-Pilotos-%n");
        while(!(pilotos[name].name).isEmpty()) {
            System.out.printf("%d - %s%nMatricula: %s%n",pilotos[name].number,pilotos[name].name, pilotos[name].matricula);
            name++;
        }
    }

       //troca
    public static void swap (Pilot [] station,int i, int j) {
        Pilot tmp  = new Pilot();
        tmp = station[i];
        station[i] = station [j];
        station[j] = tmp;
    }

    //ask the user for the vehicle number and change the data
    public static void change_data (Pilot [] pilotos, int n) {
        int num;
        System.out.print("Numero do veiculo: ");
        num = sc.nextInt();
        boolean existe = false;

        for(int i = 0; i < n; i++) { //if there is the vehicle it registers to existe
            if(pilotos[i].number == num) 
               existe = true; 
        }
        if(existe){
            System.out.println("Veiculo encontrado. Proceder a alteração de dados");
            System.out.print("Introduza novo nome: ");
            pilotos[num-1].name = sc.next();
            sc.nextLine();
            System.out.print("Introduza nova matricula: ");
            pilotos[num-1].matricula = sc.nextLine();
        }
        else
            System.out.println("Não existe o veiculo");
    }

    public static int remove_vehicle(Pilot [] pilotos, int n) {
        int num;
        System.out.println("Remoçao de um veiculo");
        System.out.print("Numero do veiculo: ");
        num = sc.nextInt();
        boolean existe = false;

        for(int i = 0; i < n; i++) { //if there is the vehicle it registers to existe
            if(pilotos[i].number == num) 
               existe = true; 
        }

        if(existe && num == n) {
            n--;
        }
        else if (existe && num < n) {
            for (int i = num-1; i < n-1; i++) {
                pilotos[i].name = pilotos[i+1].name;
                pilotos[i].matricula = pilotos[i+1].matricula;
            }
            n--;
        }
        else
            System.out.println("Não existe o veiculo");
        return n;

    }

      //print information cre by name
    public static void print_cre (Pilot [] pilotos, int n) {
        boolean troca;
        String tmpn = new String();
        String tmpm = new String();
        int nOrd = 0, name = 1;
        do {
            troca = false;
            for(int i = 0; i < n - 2 - nOrd; i++) {
                
                if(((pilotos[i].name).compareTo(pilotos[i+1].name)) > 0 && !(pilotos[i].name).isEmpty()) {
                    //swap(pilotos,i+1,i);
                    tmpn = pilotos[i+1].name;
                    pilotos[i+1].name = pilotos[i].name;
                    pilotos[i].name = tmpn;

                    tmpm = pilotos[i+1].matricula;
                    pilotos[i+1].matricula = pilotos[i].matricula;
                    pilotos[i].matricula = tmpm;

                    troca = true;
                }
            }
            nOrd++;
        }while(troca);

        System.out.printf("%n-Pilotos-%n");
        for(name = 0; name < n-1; name++){
            System.out.printf("%d - %s%nMatricula: %s%n",pilotos[name].number,pilotos[name].name, pilotos[name].matricula);
        }
    }

    //remove vehicles by name
    public static int remove_name (Pilot [] pilotos, int n) {
        
    }



}    
class Pilot {
    int number;
    String name;
    String matricula;
}
