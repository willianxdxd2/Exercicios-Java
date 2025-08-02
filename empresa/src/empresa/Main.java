package empresa;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n1;
		double hrstrab,hrsal,sal;
		System.out.println("Digite o número do funcionário, as horas trabalhadas, e o valor que recebe por horas");
		n1 = sc.nextInt();
		hrstrab=sc.nextDouble();
		hrsal=sc.nextDouble();
		sal =(double) hrstrab * hrsal;
		System.out.println("Número: " + n1);
		System.out.println("Salário: " + sal);
		sc.close();
	}

}
