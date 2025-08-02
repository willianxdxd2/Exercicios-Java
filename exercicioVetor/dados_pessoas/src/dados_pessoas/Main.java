package dados_pessoas;
import java.util.Scanner;
import entidades.pessoas;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantas pessoas vão ser digitadas? ");
		int n = sc.nextInt();
		
		pessoas[] pe = new pessoas[n];
		

		for (int i = 0 ; i < pe.length ; i++) {
			
			pe[i] = new pessoas();
			
			System.out.println("Digite a altura: ");
			pe[i].setAltura(sc.nextDouble());
			sc.nextLine();
			System.out.println("Digite o gênero: ");
			pe[i].setGenero(sc.next().charAt(0));	
		}
		double maior=pe[0].getAltura();
		double menor=pe[0].getAltura();
		double alturaM = 0;
		int contF=0;
		int contM = 0;
		for (int i = 0 ; i < pe.length ; i++) {
			if (maior < pe[i].getAltura()) {
				maior = pe[i].getAltura();
			}
			if (menor > pe[i].getAltura()){
				menor = pe[i].getAltura();
			}
			if (pe[i].getGenero() == 'f') {
				alturaM = pe[i].getAltura() + alturaM;
				contF += 1;
			}
			else {
				contM += 1;
			}
		}
		double media = alturaM / contF;
		System.out.println("Menor altura: " + menor);
		System.out.println("Maior altura: " + maior);
		System.out.println("Média altura mulheres: " + media);
		System.out.println("Numero de homens: " + contM);
		sc.close();
	}

}
