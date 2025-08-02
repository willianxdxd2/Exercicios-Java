package exercicioIF5;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int codigo;
		double unidades;
		System.out.println("Digite o codigo do item:\n"
				+ "1- cachorro quente 4$\n"
				+ "2- X-salada 4,50$\n"
				+ "3- X-Bacon 5.00$\n"
				+ "4- Torrada simples 2.0$\n"
				+ "5- Refrigerante 1.50$	\n");
		codigo = sc.nextInt();
		System.out.println("Agora digite as unidades desejadas");
		unidades = sc.nextInt();
		
		if (codigo == 1) {
			unidades = unidades * 4;
		}
		else if (codigo == 2) {
			unidades = unidades * 4.50;
		}
		else if (codigo == 3) {
			unidades = unidades * 5;
		}
		else if (codigo == 4) {
			unidades = unidades * 2;
		}
		else if (codigo == 5) {
			unidades = unidades * 1.50;
		}
		
		System.out.println("Preço a se pagar é de " + unidades);
		
		}
	}


