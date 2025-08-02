package areas;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		double a,b,c,triangulo_retangulo,circulo,trapezio,quadrado,retangulo;
		
		System.out.println("Insira os valores de abc");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		triangulo_retangulo =  a * c / 2;
		circulo= Math.pow(c, 2) * 3.14159;
		trapezio = (((b + a) * c) / 2);
		quadrado = Math.pow(b,2);
		retangulo = a * b;
		
		System.out.println("Triangulo Retangulo = " + triangulo_retangulo);
		System.out.println("Circulo = " + circulo);
		System.out.println("Trapezio = " + trapezio);
		System.out.println("Quadrado = "+ quadrado);
		System.out.println("Retangulo = "+ retangulo);
	}

}
