package aplication;
import java.util.Locale;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		Triangle x , y;
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("ESCREVA TRIANGULO X");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		System.out.println("ESCREVA TRIANGULO Y");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		double AreaX=x.area();
		double AreaY=y.area();
		
		
		System.out.println("Triangle x area : " + AreaX);
		System.out.println("Triangle Y area : " + AreaY);
		
		if (AreaX > AreaY) {
			
			System.out.println("HIgher " + AreaX);
		}
		else {
			System.out.println("HIgher " + AreaY);
		}
	}

}
