package soma_vetor;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int n1,n2,soma;
		double media;
		Scanner sc = new Scanner(System.in);
		System.out.println("digite o tamanho do vetor");
		n1 = sc.nextInt();
		int[] vetor =new int[n1];
		soma = 0;
		for (int i = 0 ; i < n1;i++) {
			System.out.println("Digite cada numero do vetor");
			vetor[i] = sc.nextInt();
			soma = vetor[i] + soma;
		}

		System.out.println("Valores: ");
		for (int i = 0 ; i < n1;i++) {
			System.out.println(+ vetor[i]);

		}
		media = (double)soma / (double)n1;
		System.out.println("Media" + media);
		System.out.println("soma" + soma);
		
		
		
		
		
	}

}
