import java.util.Scanner;

public class Ex11_1 {
    static Scanner sc = new Scanner (System.in);
    
    public static void main (String [] args) {
        Matrix_size A = new Matrix_size();
        Matrix_size B = new Matrix_size();
        int [][] matrix_A;
        int [][] matrix_B;
        int [][] multi;


        do{
            System.out.println("Matriz A");
            A = size_of_matrix(A);
            System.out.println("Matriz B");
            B = size_of_matrix(B);
            if(A.cols != B.lines)
                System.out.println("Numeros de colunas de A tem de ser igual a num de lihas B");
        }while(A.cols != B.lines);
        
        matrix_A = matrix_content(A);
        
        matrix_B = matrix_content(B);
        multi = multi(matrix_A, matrix_B, A, B);

        for(int i = 0; i < A.cols;i++) {
            for(int j = 0; j < B.lines;j++)
                System.out.print(multi[i][j] + " ");
            System.out.println();
        }


    }

    public static Matrix_size size_of_matrix(Matrix_size matrix) {
        do {
            System.out.print("Numero de linhas: ");
            matrix.lines = sc.nextInt();
            System.out.print("Numero de colunas: ");
            matrix.cols = sc.nextInt();
            if(matrix.lines <= 0 || matrix.cols <= 0)
                System.out.println("MAtrix with lines or cols 0 or less than 0");
        }while(matrix.lines <= 0 || matrix.cols <= 0);
        return matrix;
    }

    public static int [][] matrix_content (Matrix_size matrix) {
        int [][] A = new int [matrix.lines][matrix.cols];
        for(int i = 0; i <A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                System.out.printf("A[%d][%d]= ", i, j);
                A[i][j] = sc.nextInt();
            }
        }
        return A;
    }

    public static int [][] multi (int [][] A, int [][] B, Matrix_size a, Matrix_size b) {
        int [][] multi = new int [a.cols][b.lines];
        int n = 0, m = 0, sum = 0;

        for(int i = 0; i < a.lines; i++) {
            for(int j = 0; j < b.cols; j++) {
                for(int k = 0; k < a.cols; k++){
                    n = A[i][k];
                    m = B[k][j];
                    sum += n*m;
                    multi[i][j] = sum;
                }
            }
        }

        return multi;
    }

}

class Matrix_size {
    int cols;
    int lines;
}

