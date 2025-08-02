package exercicioEnum1Resolvido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.Worker;
import entitiesEnums.WorkerLevel;
	
public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat	("dd/mm/yyyy");
		
		
		System.out.print("Enter department name: ");
		String Department_name = sc.nextLine();
		System.out.println("Enter worker data");
		System.out.println("Name: ");
		String workername = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workername , WorkerLevel.valueOf(workerLevel)
		,baseSalary, new Department(Department_name)); 
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		for (int i = 0 ; i < n; i++) {
			System.out.println("Enter contract number #"+ i + "data:");
			System.out.print("Date (dd/mm/yyyy)");
			Date ContractDate = sdf.parse(sc.next());
			
		}
		
	}

}
