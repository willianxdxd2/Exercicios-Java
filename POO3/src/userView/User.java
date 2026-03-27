package userView;

import java.util.Scanner;

import adm.DB_management;
import delivers.Order;
import delivers.OrderService;
import products.Products;

public class User {

	
	int n;
	Order d;
	
	
	public static void userShowSection() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a Section |1-Technology products|2-Tools Products|3-Pharmacy products|4-Fitness Products|5-Music_products|");
		int n = sc.nextInt();
		
		User.showSection(n);
		
	}
	
	
	
	
	public static String showSection(int choose) {
		
		switch(choose){
		case 1: System.out.println("Technology products: ");
				DB_management.selectSectionTec();
				break;
		case 2:
			
			System.out.println("Tools Products: ");
			DB_management.SelectTools();
			
			break;
		case 3:
			System.out.println("Pharmacy Products: ");
			DB_management.SelectPharmacy();
			break;
		case 4:
			System.out.println("Fitness Products");
			DB_management.SelectPharmacy();
			break;
		case 5:
			System.out.println("Music Products ");
			DB_management.selectmusic();
			break;
		}
		return null;
		
	}

	public String showCart() {
		System.out.println("A cart has been created! wanna show it?");
		Scanner sc = new Scanner(System.in);
		String r = sc.nextLine();
		
		if(r.equals("Yes") && r.equals("yes") && r.equals("y")) {
			
			OrderService os = new OrderService();
			
			for (Products o : os.getPrlist()) {
				System.out.println(o.getProduct_name());
			}
			
		}
		else {
			System.out.println("Cart closed");
		}
		
		return null;
	}

	
	public void removeProduct(int orders_id,int product_id,int Category_id) {
		System.out.println("This is your current product selected to delete, are you sure? ");
		DB_management.SelectProductCart(orders_id, product_id, Category_id);
		
		Scanner sc = new Scanner(System.in);
		String r = sc.nextLine();
		
		if(r.equals("Yes") || r.equals("yes") || r.equals("y")) {
			
			System.out.println("Product has been deleted from cart");
			DB_management.deleteProductCart(orders_id, product_id, Category_id);
		}else{
			System.out.println("Product deletion was canceled.");
		}
		
		
	}

	public static void findUser() {
		System.out.println("Wanna open list of users?");
		Scanner sc = new Scanner(System.in);
		String r= sc.nextLine();
		
		if(r.equals("Yes") || r.equals("yes") || r.equals("y")) {
			
			DB_management.selectAllUsers();
		}else {
			System.out.println("User Selection has been canceled!");
		}
		
	}
	
	
	
	
	
	public static void OpenOrder(String cpf ,int user_id) {
		
		
		String state = "open_order";
		
		DB_management.InsertOrder(user_id, state, cpf);
		
	}
	
	
	
	public static void requestingOpenOrder() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Wanna open order? ");
		String r = sc.nextLine();
		
		if(r.equals("Yes") || r.equals("yes") || r.equals("y")) {
			
			System.out.println("Enter a valid cpf: ");
			String cpf = sc.nextLine();
			System.out.println("Enter user id: ");
			int user_id = sc.nextInt();
			
			System.out.println("Your order was open successfully!");
			User.OpenOrder(cpf, user_id);
			
			System.out.println("Your Order id is: (Don't lose it!)");
			DB_management.selectIdOrder(user_id);
			
			
		}else {
			System.out.println("Order Opening has been canceled!");
		}}
	
	public static void addProductCart(int order_id,int product_id,int category_id,int quantity,String cpf) {
		
		DB_management.SelectBuyngProduct(category_id, product_id,quantity);
		
		DB_management.UpdateStockQuantity(category_id, product_id, quantity);
		
		
		
		Double totalprice =  DB_management.SelectTotalPrice(category_id, product_id, quantity);
		 Double totalweight = DB_management.SelectTotalWeight(category_id, product_id, quantity);
		
		 
		 OrderService os = new OrderService();
		 String state = "waiting_conclusion";
		 if(os.cpf_validation(cpf)) {
			 DB_management.insertIntoOrdersToProducts(order_id, product_id, category_id, quantity, cpf, state, totalweight, totalprice);
		 }else {
			 System.out.println("Invalid cpf");
		 }
		 
	}}
	


