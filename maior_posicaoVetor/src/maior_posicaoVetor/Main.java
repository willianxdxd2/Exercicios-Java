package maior_posicaoVetor;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantos números você vai digitar? ");
		int n = sc.nextInt();
		
		double[] vet = new double[n];
		double maior = 0;
		
		for (int i=0 ; i < vet.length;i++) {
			
			System.out.println("Digite um número");
			vet[i] = sc.nextDouble();
			if (maior < vet[i]) {
				maior = vet[i];
			}
		}
		System.out.println("Maior valor: " + maior);
		System.out.println("Sua posição no vetor: ");
		for (int i=0 ; i < vet.length;i++) {
			if (maior == vet[i]) {
				System.out.println(i);
			}
		
		}
	}

}
