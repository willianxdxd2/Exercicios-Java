package exercicio2;
import java.util.Locale;
import java.util.Scanner;
public class Aplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		Funcionario func = new Funcionario();
				
		System.out.println("Digite o nome do funcionário: ");
		func.nome = sc.nextLine();
		System.out.println("Digite o Salário bruto: ");
		func.salbruto = sc.nextDouble();
		System.out.println("Digite a taxa de imposto: ");
		func.taxa = sc.nextDouble();
		
		System.out.println();
		System.out.println("Empregado" + func);
		System.out.println();
		System.out.println("Quantos porcento quer acrescentar no salario do funcionario?");
		double porcentagem = sc.nextDouble();
		func.aumento(porcentagem);
		System.out.println();
		System.out.println("Updated data: " + func);
		sc.close();
	}

}
