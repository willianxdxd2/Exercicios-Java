package dif;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double a,b,c,d,formula;
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite os valores de a b c d: ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		d = sc.nextDouble();
		formula = (a*b - c * d);
		
		System.out.println("Formula = " + formula);

	}

}
