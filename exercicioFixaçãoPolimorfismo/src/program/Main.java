package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of products");
		int n = sc.nextInt();
		Product pr = new Product();
		Product ip = new ImportedProduct();
		Product up = new UsedProduct();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sc.nextLine();
		List<Product> list = new ArrayList<>();
		for (int i = 0;i<n;i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			} else if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String date = sc.nextLine();
				list.add(new UsedProduct(name, price, sdf.parse(date)));
			} else {
				list.add(new Product(name, price));
			}
		
		}	
		System.out.println("\nPRICE TAGS:");
		for (Product p : list) {
			System.out.println(p);
		}
		
	}

}
