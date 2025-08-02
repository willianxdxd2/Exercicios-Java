package matrizFixação;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a quantidade de linhas e colunas");
		int m = sc.nextInt();
		int n = sc.nextInt();
		int mat[][] = new int[m][n];
		
		for (int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++)
				mat[i][j]= sc.nextInt();
		}
		System.out.println("Position: ");
		int procurar = sc.nextInt();
		
		for (int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if (procurar == mat[i][j]) {
					System.out.println("position: " + i +","+ j + " " );
					if(j > 0) {
							System.out.println("left: " + mat[i][j-1]);
					 }else{
						System.out.println("Não há left");
					}
					if (j < n - 1) {
							System.out.println("right: " + mat[i][j+1]);
					} else {
						System.out.println("Não há right");
					}
					if(i > 0) {
							System.out.println("up: " + mat[i-1][j]);
					} else {
						System.out.println("no up");
					}if (i < m -1 ) {
							System.out.println("down: " + mat[i+1][j]);
					} else {
						System.out.println("No down");
					}
				}
				
				
		}}
		
	}

}
