package crescente;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int n1,n2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite um número");
		n1 = sc.nextInt();
		System.out.println("Digite um número");
		n2 = sc.nextInt();
		

		while(n1 != n2) {
		
			System.out.println("Digite um número");
			n1 = sc.nextInt();
			System.out.println("Digite um número");
			n2 = sc.nextInt();			
			
			if (n1 > n2){
				System.out.println("Decrescente");
			}else { 
			System.out.println("Crescente");
			}
			
			
		}
	}

}
