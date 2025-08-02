package for3;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		double n1,n2,n3,media;
		
		while (true) {
		System.out.println("Digite a quantidade de valores que vai digitar");
		n = sc.nextInt();
		n3=0;
		for (int i = 0 ; i < n;i++) {
			
			System.out.println("Insira valor de amostra numero um" );
			n1 = sc.nextDouble();
			System.out.println("Insira valor de amostra numero dois" );
			n2 = sc.nextDouble();
			System.out.println("Insira valor de amostra numero tres" );
			n3 = sc.nextDouble();
			
			if (n3 != 0 ) {
				
				media =((n1 * 2) + (n2 * 3) + (n3 * 5))/(2+3+5);
				System.out.println("A média ponderada é de: " + media);
			}
		}
		}
		
	}

}
