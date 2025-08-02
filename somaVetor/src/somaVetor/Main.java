package somaVetor;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual vai ser o tamanho do vetor?");
		int n = sc.nextInt();
		double[] vet = new double[n];
		double soma = 0;
		for (int i = 0 ; i < vet.length; i++) {
			System.out.println("Digite um numero: na posição: " + i);
			vet[i] = sc.nextDouble();
			soma = vet[i] + soma;
		}
		System.out.println("Valores: ");
		
		for (int i = 0 ; i < vet.length; i++) {
			System.out.print(" " + vet[i] + " ");
		}
		double media = soma / n;
		System.out.println("Soma: " + soma);
		System.out.println("Média: " + media);
		
	}

}
