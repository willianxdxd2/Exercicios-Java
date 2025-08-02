package vetoresAprovados;
import java.util.Scanner;
import entities.pessoas;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantos alunos serão digitados? ");
		int n = sc.nextInt();
		sc.nextLine();
		double[] media = new double[n];
		pessoas[] pe = new pessoas[n];
		
		for (int i = 0 ; i < pe.length ; i++) {
			pe[i] = new pessoas();
			System.out.println("Digite o nome da pessoa: ");
					
			pe[i].setNome(sc.nextLine());
			
			
			System.out.println("Digite a primeira nota: ");
			pe[i].setNota1(sc.nextDouble());
			
			System.out.println("Digite a segunda nota: ");
			pe[i].setNota2(sc.nextDouble());
			
			sc.nextLine();
			
			media[i] = (pe[i].getNota1() + pe[i].getNota2()) / 2;
			
		}
		
		System.out.println("Alunos aprovados: ");
		
		for (int i = 0 ; i < pe.length ; i++) {
			if (media[i] >= 6.0) {
				System.out.println("O aluno: " + pe[i].getNome() + " Foi aprovado" +
				" Com a média de " + media[i]);
			}
			
			
		}
		
	}

}
