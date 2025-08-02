package circuloraio;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		double n1,pi,formula;
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite o raio");
		pi = 3.14159;
		n1 = sc.nextDouble();
		formula = pi * Math.pow(n1, 2);
		
		System.out.println("Resultado = " + formula);
		
		sc.close();
		

	}

}
