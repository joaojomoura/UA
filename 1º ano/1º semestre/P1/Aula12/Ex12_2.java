import java.util.Scanner;

public class Ex12_2 {
    public static Scanner sc = new Scanner (System.in);
    private static Pilot pilot;

    public static void main (String [] args) {
        //variaveis
        Pilot pilotos [] = new Pilot [10];
        int n;

        n = pilot_read(pilotos);
        print_decre(pilotos, n);

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
                if(pilotos[i].number < pilotos[i].number) {
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

}    
class Pilot {
    int number;
    String name;
    String matricula;
}
