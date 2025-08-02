package ex;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		int n1, n2,duracao;
		Scanner sc = new Scanner (System.in);
		System.out.println("Hora inicial: ");
		n1 = sc.nextInt();
		System.out.println("Hora Final: ");
		n2 = sc.nextInt();
		
		if (n1 < n2 ) {
			duracao = n2 - n1; 	
	}
		else {
			
			duracao = 24 - n1 + n2;
		}
		
		
		System.out.println("O jogo durou: " + duracao + "Horas");
		
}
}