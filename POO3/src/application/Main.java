package application;

import java.util.ArrayList;
import java.util.Scanner;

import adm.DB_management;
import delivers.Order;
import entities.Status;
import login.LocalTokenStorage;
import login.Login;
import login.Register;
import payment.Charge;
import payment.Credit;
import payment.Debit;
import payment.Pix;
import products.Products;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		String token = LocalTokenStorage.read();
		boolean logged = false;
		if(token != null && DB_management.isTokenValid(token)) {
			System.out.println("still login in");
			logged = true;
			Integer userid = DB_management.getUserIdByToken(token);
		}else {
			LocalTokenStorage.clear();
			System.out.println("Need login");
			System.out.println("Login or Register? ");
			String r = sc.nextLine();
			System.out.println("Enter fullname");
			String fullname = sc.nextLine();
			System.out.println("Enter password");
			String password = sc.nextLine();
			System.out.println("Enter email");
			String email = sc.nextLine();
			System.out.println("Cellphone: ");
			Integer cellphone = sc.nextInt();
			if(r.equals("Login")) {
				Login acclogin = new Login(fullname,password,email,cellphone);
				acclogin.login(fullname, password, email);
			}else if(r.equals("Register")) {
						Register accRegister = new Register(fullname,password,email,cellphone);
						accRegister.verifyemail(email);
						accRegister.verifypassword(password);
						accRegister.verifyuser(fullname);
						logged = true;
			}}
		
			if(logged == true) {
				
				
			System.out.println("| Welcome do big seller! make your first deliver |");
			
	
			ArrayList<Products> prlist = new ArrayList<>();
			boolean keep_buyng = true;
			while(keep_buyng) {
				System.out.println("Select a product "
						+ "\n (1)Door, Weight: 8kgs, Price:300.0 ");
				System.out.println(" (2)Couch,Weight 5kgs, Price: 200.0");
				Integer choose = sc.nextInt();
			
			switch(choose) {
			case 1:{
				System.out.println("Door selected");
				String product_name = "Door";
				Integer weight = 8;
				Double price = 300.0;
				System.out.println("How many? ");
				Integer quantity = sc.nextInt();
				sc.nextLine();
				System.out.println(quantity + "º Doors added to cart, Price of: " + 300 * quantity + " Kgs: " + 8 * quantity);
				Products pr = new Products(product_name,weight,price,quantity);
				prlist.add(pr);
				System.out.println("Keep buyng? Yes/No");
				String resp = sc.nextLine();
				if(resp.equalsIgnoreCase("No")) {
					keep_buyng = false;
				}
				
				
				break;
			}
			case 2:{
				System.out.println("Couch selected");
				String product_name = ("Couch");
				Integer weight = 5;
				Double price = 200.0;
				System.out.println("How many? ");
				Integer quantity = sc.nextInt();
				sc.nextLine();
				System.out.println(quantity + "º Couch added to cart, Price of: " + 200 * quantity + " Kgs: " + 5 * quantity);
				Products pr = new Products(product_name,weight,price,quantity);
				prlist.add(pr);
				System.out.println("Keep buyng? Yes/No");
				String resp = sc.nextLine();
				if(resp.equalsIgnoreCase("No")) {
					keep_buyng = false;
				}
			}}
			}
			System.out.println("Make your deliver");
			System.out.println("Enter a valid cpf: ");
			Long cpf = sc.nextLong();
		
			Integer id = DB_management.getUserIdByToken(token);
			String user = DB_management.selectname(id);
			
			System.out.println("Enter payment type: (1)Debit 10%tax  | (2)Credit 25%tax | (3)Pix no tax |");
			Integer choosepayment = sc.nextInt();
			System.out.println("payment value: ");
			Double value = sc.nextDouble();
			sc.nextLine();
			Charge ch = null;
			Order dl = new Order(user,prlist,cpf);
			boolean pix = false;
			switch(choosepayment) {
			case 1:{
			
				ch = new Debit(user,value,dl.getDeliverprice(),Status.PENDING_PAYMENT);
				
				break;
			}
			case 2:{
				
				ch = new Credit(user,value,dl.getDeliverprice(),Status.PENDING_PAYMENT);
				
				break;
			}
			case 3:{
				pix = true;
				ch = new Pix(user,value,dl.getDeliverprice(), Status.PENDING_PAYMENT);
				
				break;
			}}
			dl.setCh(ch);
			
			if(pix == true) {
				ch.generateToken();
				System.out.println("Enter token");
				Integer tokenn = sc.nextInt();
				sc.nextLine();
				System.out.println("Do you wanna continue with payment? Yes | No");
				String r = sc.nextLine();
				if(r.equalsIgnoreCase("Yes")) {
					ch.pay(tokenn);
				}else {
					System.out.println("Error on payment");
				}
			}else {
				System.out.println("Do you wanna continue with payment? Yes | No");
				String r = sc.nextLine();
				if(r.equalsIgnoreCase("Yes")) {
					ch.pay();
				}else {
					System.out.println("Error on payment");
				}
			}
			
			
				
				
			
				
			
		}else {
			System.out.println("Need login to continue");
		}
		

	
		
	}}


