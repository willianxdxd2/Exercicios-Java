package media_pares;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos elementos vai ter o vetor?");
		int n = sc.nextInt();
		int[] vet = new int[n];
		int soma = 0;
		int pares = 0;
		for (int i=0;i<vet.length;i++) {
			System.out.println("Digite um número: ");
			vet[i] = sc.nextInt();
			if (vet[i] % 2 == 0 ) {
				soma = soma + vet[i];
				pares += 1;			}
			
			
		}
		double media;
		if (pares > 0 ) {
			media = soma / pares;
			System.out.println("Média dos pares: " + media);
		}
		
		if (soma == 0) {
			System.out.println("Nenhum par");
		}
		sc.close();
	}

}
