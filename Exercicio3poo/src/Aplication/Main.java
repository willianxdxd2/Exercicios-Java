package Aplication;
import java.util.Scanner;
import java.util.Locale;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		aluno alu = new aluno();
		
		System.out.println("Digite o nome do aluno");
		alu.nome=sc.nextLine();
		System.out.println("Digite a primeira nota");
		alu.nota1=sc.nextDouble();
		System.out.println("Digite a segunda nota");
		alu.nota2=sc.nextDouble();
		System.out.println("Digite a terceira nota");
		alu.nota3=sc.nextDouble();
		
		System.out.println("Final grade= "  + alu.notafinal());
		System.out.println(alu.toString());
		
		

	}

}
