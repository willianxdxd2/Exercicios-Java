package mais_velho;
import java.util.Scanner;
import pacote.pessoas;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantas pessoas você vai digitar?");
		int n = sc.nextInt();
		pessoas[] pe = new pessoas[n];
		int mais_velho = 0;
		int posicao = 0;
		for (int i = 0;i < n ;i++) {
			pe[i] = new pessoas();
			System.out.println("Digite o nome da pessoa: ");
			sc.nextLine();
			pe[i].setNome(sc.nextLine());
			
			
			
			System.out.println("Digite a idade da pessoa: ");
			pe[i].setIdade(sc.nextInt());
			if (mais_velho == 0 ) {
				mais_velho = pe[0].getIdade();
			}
			if (pe[i].getIdade() > mais_velho ) {
				mais_velho = pe[i].getIdade();
				posicao = i;
			}	
		}
		

		System.out.println("A idade do mais velho é de: " + mais_velho );
		System.out.println("O nome do mais velho é de: " + pe[posicao].getNome());
		System.out.println("Posição: " + posicao);
		System.out.println("Pessoas e suas respectivas idades: ");
		for(int i = 0 ; i < n;i++) {
			
			System.out.println(pe[i].toString());
			
		}
		sc.close();
	}

}
