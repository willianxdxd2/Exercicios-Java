package alturaVetor;
import java.util.Scanner;
import entidades.pessoa;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantas pessoas serão digitadas? ");
		
		int n = sc.nextInt();
		pessoa[] vet = new pessoa[n];
		String[] vet_idade = new String [n];
		double soma_altura=0;
		int menor_dezesseis = 0;
		for (int i=0 ; i < n; i++) {
			sc.nextLine();
			System.out.println("Nome");
			String nome = sc.nextLine();
			
			System.out.println("idade");
			int idade = sc.nextInt();
			System.out.println("altura");
			sc.nextLine();
			double altura = sc.nextDouble();
			vet[i] = new pessoa(nome,idade,altura);
			soma_altura = altura + soma_altura;
			if (idade < 16) {
				vet_idade[menor_dezesseis] = nome;
				menor_dezesseis = 1 + menor_dezesseis;
			}
			}
			
			double media_altura = soma_altura / n; 
			double porcentagem_dezesseis = (menor_dezesseis * 100) / n; 
			System.out.println("Altura média: " + media_altura);
			System.out.println("pessoas com menos de 16: " + porcentagem_dezesseis+ "%");
			for (int i=0 ; i < menor_dezesseis; i++) {
				System.out.println(vet_idade[i]);
			}
		}
		
		
		
		
		
	}


