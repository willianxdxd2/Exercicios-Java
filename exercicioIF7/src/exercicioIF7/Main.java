package exercicioIF7;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("escreva as coordenadas");
		double n1,n2;
		n1 = sc.nextDouble();
		n2 = sc.nextDouble();
		
		if (n1 > 0 && n2 > 0) {
			System.out.println("Quadrante 1");
		}
		else if(n1 < 0 && n2 > 0) {
			System.out.println("Quadrante 2");	
		}
		else if(n1 < 0 && n2 < 0) {
			System.out.println("Quadrante 3");
		}
		else if(n1 > 0 && n2 < 0) {
			System.out.println("Quadrante 4");
	}
		else {
			System.out.println("Posição de origem");
		}
	}
}
