package abaixo_da_media;
import java.util.Scanner;
public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantos elementos vai ter o vetor?");
		int n = sc.nextInt();
		double[] vet = new double[n];
		
		for(int i = 0 ; i < vet.length;i++) {
			
			System.out.println("Digite um número");
			vet[i] = sc.nextDouble();
			
		}
		System.out.println("Média vetor: ");
		double soma = 0;
		for(int i = 0 ; i < vet.length;i++) {
			soma = soma + vet[i];
			
		}
		
		double media;
		media  = soma / n;
		System.out.println("A média deu: " + media);
		System.out.println("Elementos abaixo da média: ");
		for(int i = 0 ; i < vet.length;i++) {
			if (vet[i] < media) {
				System.out.println(vet[i]);
			}
			
		}
		sc.close();
	}

}
