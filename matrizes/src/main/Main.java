package main;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m , n,i;
		System.out.println("quantas linhas vai ter a matriz?");
		m = sc.nextInt();
		System.out.println("Quantas colunas vai ter a matriz? ");
		n = sc.nextInt();
		
		int[][] mat = new int[m][n];
		
		for(i= 0; i < m ; i++);
			for(int j = 0;j < n ; j++)
				System.out.println("Elemento [" + i + "," + j+ "]: ");
				mat[i][j] = sc.nextInt();
		
	System.out.println();
	
	System.out.println("Matriz digitada: ");
	
for (i = 0;i < m ; i++){
	for (int j = 0 ; j < n ; j++ )
		System.out.println(mat[i][j] + " ");
			}
	}
	}

}
