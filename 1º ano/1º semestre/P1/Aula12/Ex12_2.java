import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Ex12_2 {
    public static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) {
        //variaveis
        Pilot pilotos [] = new Pilot [10];
        int n = 0, choice = 0;
        
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1: 
                    n = pilot_read(pilotos);
                    break;
                case 2:
                    print_decre(pilotos, n);
                    break;
                case 3:
                    change_data(pilotos, n);
                    break;
                case 4:
                    n = number_vehicle(pilotos, n);
                    break;
                case 5:
                    print_cre(pilotos, n);
                    break;
                case 6:
                    n = remove_name(pilotos, n);
                    break;
                case 7:
                    matriculaValida(pilotos, n);
                    break;
                case 8:
                    System.out.println("fim do programa");
                    break;
                default:
                    System.out.println("Opção invalida!");
            }    
        }while(choice != 8);

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
        String tmpn = new String();
        String tmpm = new String();
        int nOrd = 0, name = 0, num = 0;
        do {
            troca = false;
            for(int i = 0; i < n - 2 - nOrd; i++) {
                if(pilotos[i].number < pilotos[i+1].number) {
                    tmpn = pilotos[i].name;
                    pilotos[i].name = pilotos[i+1].name;
                    pilotos[i+1].name = tmpn;

                    tmpm = pilotos[i].matricula;
                    pilotos[i].matricula = pilotos[i+1].matricula;
                    pilotos[i+1].matricula = tmpm;
                    
                    num = pilotos[i].number;
                    pilotos[i].number = pilotos[i+1].number;
                    pilotos[i+1].number = num;
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
            if(pilotos[i].number == num){
               existe = true;
               System.out.printf("%d - %s%nMatricula: %s%n",pilotos[i].number,pilotos[i].name, pilotos[i].matricula); 
            }
        }
        if(existe){
            System.out.println("Veiculo encontrado. Proceder a alteração de dados");
            System.out.print("Introduza novo nome: ");
            pilotos[num].name = sc.next();
            sc.nextLine();
            System.out.print("Introduza nova matricula: ");
            pilotos[num].matricula = sc.nextLine();
        }
        else
            System.out.println("Não existe o veiculo");
    }
    public static int number_vehicle(Pilot [] pilotos, int n) {
        int num;
        System.out.println("Remoçao de um veiculo");
        System.out.print("Numero do veiculo: ");
        num = sc.nextInt();
        n = remove_vehicle(pilotos, n, num);
        return n;
    }
    public static int remove_vehicle(Pilot [] pilotos, int n,int num) {
        
        boolean existe = false;

        for(int i = 0; i < n-1; i++) { //if there is the vehicle it registers to existe
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
        int nOrd = 0, name = 1, num = 0;
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
                    
                    num = pilotos[i+1].number;
                    pilotos[i+1].number = pilotos[i].number;
                    pilotos[i].number = num;


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
        String remove = new String();
        int str_remove = 0;
        String list [] = new String [n];
        int num [] = new int [n]; 
        System.out.print("Qual o nome a remover: ");
        remove = sc.nextLine();
        int num2 = 0;

        //store name and numbers in arrays
        for(int i = 0; i < n; i++) {
            if((pilotos[i].name).indexOf(remove) != -1) {
                list[str_remove] = pilotos[i].name;
                num [str_remove] = pilotos[i].number;
                str_remove++;
            }
        }
        //if there's only one name just remove
        if(str_remove == 1) {
            System.out.printf("A remover %s%n",list[str_remove-1]);
            n = remove_vehicle(pilotos, n, num[str_remove-1]);
        }
        //if there's more names, shows a list and ask the user what to remove
        if(str_remove > 1) {
            for (int i = 0; i < str_remove; i++) {
                System.out.printf("%d - %s%n",i,list[i]);
            }
            System.out.print("Qual deseja remover: ");
            num2 = sc.nextInt();
            n = remove_vehicle(pilotos, n, num[num2]);
        }
        return n;

    }

    public static boolean isValid (String matricula) {
        if(matricula.length() != 8)
            return false;
        if(matricula.charAt(2) != '-' || matricula.charAt(5) != '-' )
            return false;
        int letras = 0, numeros = 0;
        boolean junto = false;

        for (int i = 0; i < 8; i++) {
            if(Character.isDigit(matricula.charAt(i)))
                numeros++;
            else {
                if (Character.isLetter(matricula.charAt(i)) && matricula.charAt(i) == (matricula.toUpperCase().charAt(i))) {   
                    letras++;                                                            
   
                    if (!junto && i < 7 && Character.isLetter(matricula.charAt(i + 1)))                   
                        junto = true;                                              
                }
            }
        }
        if (numeros == 4 && letras == 2 && junto)
            return true;
        return false;
    }
    //verify license plate if is valid
    public static void matriculaValida (Pilot [] pilotos, int n) {
        for (int i = 0; i < n-1; i++){
            while(!isValid(pilotos[i].matricula)) {
                System.out.printf("%nMatricula incorreta do carro numero %d%n",pilotos[i].number);
                System.out.print("Coloque matricula valida: ");
                pilotos[i].matricula = sc.nextLine();
            }
        }
    }

    public static void menu () {
        System.out.println("Gestão de uma prova automóvel:");
        System.out.println("    1 - Inserir informação dos pilotos");
        System.out.println("    2 - Listar pilotos ordenados pelo número da viatura");
        System.out.println("    3 - Alterar informação de um piloto");
        System.out.println("    4 - Remover piloto com base no número da viatura");
        System.out.println("    5 - Listar pilotos ordenados pelo nome");
        System.out.println("    6 - Remover piloto(s) com base no nome");
        System.out.println("    7 - Validar matriculas");
        System.out.println("    8 - Terminar o programa");
        System.out.print("      Opção ->");
    }



}    
class Pilot {
    int number;
    String name;
    String matricula;
}
