package while1;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite a senha");
		int senha = sc.nextInt();
		
		while (senha != 2002) {
			System.out.println("senha errada tente novamente");
			senha = sc.nextInt();
		}
		
		System.out.println("Senha correta");
	}

}
