package menor_de_tes;
import java.util.Scanner;
import java.util.Locale;
public class Main {

	public static void main(String[] args) {
		int i,troca;
		int[] numeros = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		
		for (i=0 ; i < 3 ; i++) {
		System.out.println("digite um numero");
		numeros[i] =sc.nextInt();
		}
		troca = numeros[0];
		for (i=0 ; i < 3 ; i++) {
			if (numeros[i] < troca) {
				troca = numeros[i];
			}
		}
		
		
		System.out.println("O numero menor dentre os 3 é: " + troca);
		
		
   }
}