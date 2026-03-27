package userView;

import java.util.Scanner;

import adm.DB_management;

public class Main {

	public static void main(String[] args) {
		
		//User.userShowSection();
		
		//User.findUser();
		//User.requestingOpenOrder();
		//User.addProductCart(1, 2, 4);
		//DB_management.selectIdOrder(2);
		
		String cpf = "529.982.247-25";
		User.addProductCart(5,3,3,2, cpf);
		


	}

}
