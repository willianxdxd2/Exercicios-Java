package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.employee;
import entities.outSourcedEmployee;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<employee> list = new ArrayList<>();
		System.out.print("Enter the number of employees: ");
		int n =sc.nextInt();
		
		for (int i = 0 ; i < n;i++) {
			System.out.println("Employee #" + i + "data: ");
			System.out.println("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Hours: ");
			int Hours = sc.nextInt();
			System.out.println("valuePerHour:");
			double valuePerHour = sc.nextDouble();
			if (ch == 'y') { 
				System.out.println("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				
				list.add(new outSourcedEmployee(name, Hours, valuePerHour, additionalCharge));
			}
			else {
				
				list.add(new employee(name ,Hours, valuePerHour));
			}
		}
		
		System.out.println();
		System.out.println("Payments");
		
		for (employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f",emp.payment()));
		}
		
		
		
		
		
		sc.close();
	}

}
