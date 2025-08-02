package vetor1;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double[] vet = new double [n];
		double soma = 0;
		for(int i=0; i<n ;i++) {
			vet[i] = sc.nextDouble();
			
			
			soma = vet[i] + soma;
		}
		System.out.println(soma);
		
		sc.close();
	}

}
