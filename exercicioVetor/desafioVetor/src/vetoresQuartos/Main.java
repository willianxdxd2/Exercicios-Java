package vetoresQuartos;
import quartos.Quartos;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("O tamanho dos quartos é de 0 a 9");
		Quartos[] qt = new Quartos[9];
		
		for (int i = 0 ; i < qt.length+1 ;i++) {
			qt[i] = new Quartos();	
			
		}
		
		int pos;
		for (int i = 0 ; i < qt.length ;i++) {
			
		System.out.println("Deseja parar a seleção de quartos? s/n");
		char resp = sc.next().charAt(0);
		sc.nextLine();
				if(resp == 's' || resp == 'S') {
					break;
				}

		System.out.println("Escolha um Quarto de 0 a 9: ");
		pos = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Nome: "  );
		
		qt[pos].setNome(sc.nextLine());
		
		System.out.println("Email: "  );
		
		qt[pos].setEmail(sc.nextLine());
		}
		
		System.out.println("Quartos ocupados: ");
	
		
		
		for (int i = 0 ; i < qt.length +1 ;i++) {
			
			    System.out.println("--------------------------------");
			
				System.out.println("Nome: " + qt[i].getNome() );
				
				System.out.println("Email: " + qt[i].getEmail() );
				
				System.out.println("Quarto: " + i);
				
				System.out.println("--------------------------------");
			
		}
		
	}

}
