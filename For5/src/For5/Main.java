package For5;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,n2,n3,n4;
		System.out.println("Escreva para saber o fatorial do numero escrito");
		n = sc.nextInt();
		n3 = 0;
		n4 = n;
		for (int i=1;i< n4;i++) {
			n = n*(n4-i);
			
			System.out.println("Fatoriando.." + n );
		}
		System.out.println("Valor Fatoriado = " + );
	}	

}
