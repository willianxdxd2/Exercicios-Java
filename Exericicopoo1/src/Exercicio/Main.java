package Exercicio;

import exercicio1.retangulo;
import java.util.Scanner;
import java.util.Locale;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		retangulo ret = new retangulo();
		
		System.out.println("Insira a largura");
		ret.a = sc.nextDouble();
		System.out.println("Insira a altura");
		ret.b = sc.nextDouble();
		
		System.out.println("A area do Retangulo é de: " + ret.area());
		System.out.println("O perimetro do Retangulo é de: " + ret.perimetro());
		System.out.println("A diagonal é de: " + ret.diagonal());
		sc.close();
	}

}
