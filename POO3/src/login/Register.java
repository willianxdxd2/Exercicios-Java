package login;

import java.util.Scanner;

import adm.DB_management;

public class Register extends Account implements Account_system{


	public Register(String fullname, String email, String password, Integer cellphone) {
		super(fullname, email, password, cellphone);
		DB_management.insertuser(fullname,password,email,cellphone);
	
	
	}

	@Override
	public boolean verifypassword(String password) {
		Integer ultimoid = DB_management.searchLastId();
		Scanner sc = new Scanner(System.in);
		System.out.println("Repeat password: ");
		String password1 = sc.nextLine();
		for(int i = 0 ; i <= ultimoid;i++) {
			
			String nome = DB_management.searchfield("password",i);

			if(password.equals(nome) && password1.equals(password)){
				return true;
			}
		}
	return false;
	}
	}


