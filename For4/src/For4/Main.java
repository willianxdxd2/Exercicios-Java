package For4;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n;
		System.out.println("Digite quantos numeros vc vai digitar");
		n = sc.nextInt();
		int n1,n2;
		double divisao;
		for (int i = 0; i < n; i++) {
			
			System.out.println("Digite o primeiro e o segundo numero");
			n1= sc.nextInt();
			n2= sc.nextInt();
			
			if (n1 != 0 && n2 != 0 ) {
				divisao = (double)n1 / n2;
				System.out.println("A divisão deu: " + divisao);
			}else {
					System.out.println("Operador inválido");
					
				}
					
					
					
			}
			
		}

	}

}
