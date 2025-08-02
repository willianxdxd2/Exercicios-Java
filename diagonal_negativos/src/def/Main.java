package def;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int ordem_mat;
		ordem_mat= 0;
		
		System.out.println("Digite a ordem da matriz");
		ordem_mat = sc.nextInt();
		int[][] mat = new int[ordem_mat][ordem_mat];
		for (int i = 0 ; i < ordem_mat ; i++ ) {
			for (int j = 0 ; j < ordem_mat ; j++) {
				System.out.println("Elemento ["+i+","+j+"] ");
				 mat[i][j] = sc.nextInt();
			
				}
		}
		int cont;
		cont=0;
		
		for (int i = 0 ; i < ordem_mat ; i++ ) {
			for (int j = 0 ; j < ordem_mat ; j++) {
					if (mat[i][j] < 0) {
						
						cont = cont + 1 ;
						
					}
				}
		}
		System.out.println("Negativos: " + cont);
		System.out.println("Diagonal Principal: " );
		for (int i = 0 ; i < ordem_mat ; i++ ) {
			for (int j = 0 ; j < ordem_mat ; j++) {
					if (mat[i][j] == mat[i][i]) {
						System.out.println(mat[i][j]);
					}
				}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
