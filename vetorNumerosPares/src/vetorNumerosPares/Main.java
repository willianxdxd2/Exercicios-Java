package vetorNumerosPares;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Quantos numeros vc vai digitar?");
		int n = sc.nextInt();
		int[] vet = new int [n];
		
		for (int i = 0; i < vet.length; i++) {
			System.out.println("Digite um número: na posição: " + i);
			vet[i] = sc.nextInt();
		}
		System.out.println("Numeros pares:" );
		int pares = 0;
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] % 2 == 0) {
				System.out.println(vet[i]);
				pares = pares + 1;
			}
			
		}
		
	}

}
