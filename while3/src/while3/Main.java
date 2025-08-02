package while3;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1,alcool,gasolina,diesel;
		
		alcool=0;
		gasolina = 0;
		diesel = 0;
		
		System.out.println("Digite o codigo:\n 1-Alcool \n 2-Gasolina \n 3-Diesel"); 
		
		n1 = sc.nextInt();
		
		while (n1 != 4 ) {
			
			if (n1 == 1) {
				alcool = alcool +1;
			}
			else if (n1 == 2) {
				gasolina = gasolina + 1;
			}
			else if(n1 == 3) {
				diesel = diesel + 1;
			}
			
			if (n1 != 1 && n1 != 2 && n1 != 3) {
				System.out.println("Digite um novo codigo, Muito Obrigado");
			}
			n1 = sc.nextInt();
			System.out.println("Alcool = " + alcool + "\n Gasolina =" + gasolina + "\n Diesel = " + diesel);
		}
		System.out.println("Alcool = " + alcool + "\n Gasolina =" + gasolina + "\n Diesel = " + diesel);
		
		
	}
	

}
