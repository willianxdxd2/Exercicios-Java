package primeiro_programa;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		String product1 = "Computer";
		String product2 = "Office desk";
		
		int age = 30;
		int code = 5290;
		char gender ='f';
		double price1=2100.0;
		double price2 =650.50;
		double measure= 53.234567;
		
		System.out.printf("%s, wich price is $ %.2f "
				+ "%s, wich price is $%.2f %n" , product1, price1,product2,price2);
		
		System.out.printf("record: %d years old,code %d and gender %c %n",age,code,gender);
		
		System.out.printf("measue with eight decimal places: %.8f %n" , measure);
		System.out.printf("round %.3f %n", measure);
		Locale.setDefault(Locale.US);
		System.out.printf("round %.3f %n" , measure);
		
		
	}

}
