package somaVetores;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos valores vai ter cada vetor?");
		int n = sc.nextInt();
		System.out.println("Digite os valores do vetor A");
		int[] vet = new int[n];
		int[] vet2 = new int[n];
		int[] vet3 = new int[n];
		
	for (int i = 0 ; i < vet.length; i++ ) {
			
			System.out.println("Digite o " + i + "A valor" );
			vet[i] = sc.nextInt();	
		}
	for (int i = 0 ; i < vet.length; i++ ) {
			
			System.out.println("Digite o " + i + "A valor" );
			vet2[i] = sc.nextInt();	
		}
		
		
	for (int i = 0 ; i < vet.length; i++ ) {
		System.out.println("Digite o " + i + "A valor" );
		vet3[i] = vet[i] + vet2[i];
	}
		
	System.out.println("Valor resultante: ");
	for (int i = 0 ; i < vet.length; i++ ) {
		System.out.println(vet3[i]);
		
	}
		
		
		
	sc.close();
	}

}
