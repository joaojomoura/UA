// Ex 10.4 ler ficheiro alunos, pedir ao user um nº mec e devolver nome

import java.util.Scanner;
import java.io.*;

public class Ex10_4 {
    public static Scanner sc = new Scanner (System.in);

    public static void main (String [] args) throws IOException{
        String file_name = file_name();
        Aluno [] students = new Aluno[100];
        students = read_Student(file_name);

        int mec_number = 0;

        do {
            mec_number = mec_number();

            System.out.printf("O aluno do nº mec %d e %s%n", mec_number, pesquisaBinaria(students,mec_number));
        }while (mec_number != 0); 
        //size_array(file_name);

    }

    //file name given by user
    public static String file_name () {
        System.out.print("Nome do ficheiro: ");
        String file = sc.nextLine();   //read the name of the file that has a sequence in there
        return file;
    }

    //get array of Alunos
    public static Aluno [] read_Student (String file_name ) throws IOException{
        Aluno [] students = new Aluno [100];
        File fin = new File (file_name);
        Scanner read = new Scanner (fin);
        int n = 0;

        //read file
        while(read.hasNextLine()) {
            students[n] = new Aluno();
            students[n].mec  = read.nextInt();
            students[n].name = read.nextLine();
            n++;
            
        }
        read.close();
        
        return students;

    }

    /* //discover the correct size for the array
    public static int size_array (String file_name) throws IOException {
        File fin = new File (file_name);
        Scanner read = new Scanner (fin);
        int count = 0, number = 0;

        //read file
        while (read.hasNextLine())
        {
            number = read.nextInt();
            System.out.printf("%d%n", number);
            String frase = read.nextLine();
            System.out.printf("%s%n", frase);
            count++;
            System.out.printf("%d%n",count);
        }
        read.close();
        
        return count;
    } */

    // pesquisa binária numa lista ordenada
    public static String pesquisaBinaria(Aluno[] lista, int valor) {
        int inicio=0,fim=lista.length-1,meio;
        int haValor= -1;
        do {
            meio=(inicio+fim)/2;
            if (valor > lista[meio].mec ) {
                inicio=meio+1;
            } else if (valor < lista[meio].mec) {
                fim=meio-1;
            } else {
                haValor = meio;
            }
            // System.out.printf("%d %d posicao = %d \n",inicio,fim,meio);
        } while(haValor == -1 && inicio <= fim );// não encontra e i<=f

        return lista[haValor].name;
    }

    //read number mec
    public static int mec_number () {
        int number;
        System.out.print("Numero mecanografico do aluno (0 para sair): ");
        number = sc.nextInt();
        return number;
    }

}

class Aluno {
    String name;
    int mec;
}