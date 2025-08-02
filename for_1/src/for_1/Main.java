package for_1;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
			System.out.println("Encontre os valores dos impares até o X(numero digitado");
			int x;
			x = sc.nextInt();
			
		for (int i = 0 ; i <= x ; i++) {
			
			if (i % 2 != 0 ) {
				System.out.println(i);
			
			}
		}
		
		

	}

}
