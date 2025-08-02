package for2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner  sc = new Scanner (System.in);
		int n,x,dentro,fora;
		System.out.println("qnts nujmeros vai digigtat");
		n = sc.nextInt();
		dentro = 0;
		fora = 0;
		for (int i = 0; i < n ; i++) {
			System.out.println("Digite um valor: ");
			x = sc.nextInt();
				if (x >= 10 && x <= 20) {
					dentro++;
				}
				else {
					fora++;
				}
				
	}
		System.out.println(dentro + "In\n" + fora +"Out");
	}
}
