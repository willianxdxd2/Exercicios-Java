package idades;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int idade1,idade2;
		double media;
		String nome1, nome2;
		System.out.println("Nome da primeira pessoa: ");
		nome1 = sc.nextLine();
		
		System.out.println("Digite a primeira idade: ");
		idade1 = sc.nextInt();
		
		
		System.out.println("Nome da segunda pessoa: ");
		sc.nextLine();	
		nome2 = sc.nextLine();
		
		System.out.println("Digite a primeira idade: ");
		
		
		idade2 = sc.nextInt();
		
		media = (double)(idade1 + idade2) / 2 ;
		
		System.out.println("A media entre as idades e de: " + media);
		
		
		
		
	}
}
