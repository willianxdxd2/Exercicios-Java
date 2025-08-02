package listaEmpregados;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import entities.empregado;
public class Main {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<empregado> list = new ArrayList<>();
		System.out.println("Quantos funcionários serão digitados? ");
		int n = sc.nextInt();
		
		
		for(int i = 0 ; i < n;i++) {
			empregado emp = new empregado();
			System.out.println("ID do funcionario: ");
			emp.setId(sc.nextInt());
			sc.nextLine();
			System.out.println("Nome do funcionário: ");
			emp.setNome(sc.nextLine());
			System.out.println("Salário do funcionário: ");
			emp.setSalario(sc.nextDouble());
			list.add(emp);
		}
		System.out.println("Coloque id do funcionário que tera aumento");
		int aumento = sc.nextInt();
		System.out.println("Coloque a porcentagem de aumento");
		double porcentagem = sc.nextDouble();
		for (empregado emp : list) {
		if (aumento == emp.getId()){
			double conclusão = porcentagem * emp.getSalario()/100 + emp.getSalario();
			emp.setSalario(conclusão);
		}
		System.out.println(emp);
			}
		sc.close();
		}
	}
		
			
			
		 
		

