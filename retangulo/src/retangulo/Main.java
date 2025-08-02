package retangulo;
import java.util.Locale;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		double b,h,a,p,d;
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a base do retangulo: ");
		b = sc.nextDouble();
		System.out.println("Digite a altura do retangulo: ");
		h = sc.nextDouble();
		
		a = b * h;
		p = (b * 2) +  (h * 2);
		d = Math.sqrt((b*b + h*h));
		
		System.out.println("A area do retangulo é de: " + a);
		System.out.println("O perimetro do retangulo é de: " + p);
		System.out.println("A diagonal do retangulo é de: " + d);
		
	}

}
