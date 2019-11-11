//Aula 5, Ex 2

import java.util.Scanner;

public class Ex_2 {
    
    final static Scanner sc = new Scanner (System.in);
    
    public static void main (String [] args) {
        int year = getIntPosYear("Ano: ");
        int month = getIntRangeMonth("Mes: ", 1, 12);
        
        switch (month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: 
				System.out.printf ("O mês %d do ano %d tem 31 dias.\n",month, year);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.printf ("O mês %d do ano %d tem 30 dias.\n");
				break;
			case 2:
				if (biYear(year)){
						System.out.printf ("O mês %d do ano %d tem 29 dias.\n",month, year);
					}
				else
					System.out.printf ("O mês %d do ano %d tem 28 dias.\n",month, year);
		}

		printNtimes (3, "Ola"); 
		System.out.println();
    }
    
    //function bi year
    public static boolean biYear (int year){
        if (year % 4 == 0){
					if((year % 100 != 0) || (year % 100 ==0 && year % 400 ==0))
						return true;
					}
        return false;
        
    }
    
    //function getintpos
	public static int getIntPosYear (String prompt) {
		int n;	//variable to read number from user
		
		//ask the user for a number
		do {
			System.out.print(prompt);
			n = sc.nextInt();
		} while (n <0);
		
		//return 
		return n;
	}
	
	//function getIntRangeMonth
	public static int getIntRangeMonth (String prompt, int range_min, int range_max){
		int n;
		
		//ask the user for a number
		do{
			System.out.print(prompt);
			n = sc.nextInt();
		}while(n < range_min || n > range_max);
		
		//return 
		return n;
	}

	public static void printNtimes (int n, String s)
	{
		for (int i = 0; i < n; i++)
			System.out.print(s);
	}
}
