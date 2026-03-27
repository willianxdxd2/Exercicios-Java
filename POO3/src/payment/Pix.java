package payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import adm.DB_management;
import entities.Status;
import login.LocalTokenStorage;

public class Pix extends Charge implements PaymentService{

	
	private Integer Token;


	public void generateToken() {
		Random random = new Random();
		Integer number = 100000 + random.nextInt(900000);
		this.setToken(number);
		System.out.println("Token generated: " + number);
	}

	
	public Integer getToken() {
		return Token;
	}


	public void setToken(Integer token) {
		Token = token;
	}

	@Override
	public void pay(Integer token) {
		String tokenlogin = LocalTokenStorage.read();
		Integer id = DB_management.getUserIdByToken(tokenlogin);
		String user = DB_management.selectname(id);
		if(Objects.equals(this.Token, token) && this.getIdentifier().equals(user) && this.getStatus() == Status.PENDING_PAYMENT && !invalidBalance()) {
			System.out.println("Default Debt: " + this.getDebt());
			Double newvalue = this.getValue() - this.getDebt();
			System.out.println("Debt paid Successfully!");
			System.out.println("Your balance is: " + newvalue);
		}else {
			System.out.println("Error on payng debt");
		}
		//immediate payment, no tax
	}



	public Pix(String identifier, Double value, Double deliverprice, Status status) {
	    this.setIdentifier(identifier);
	    this.setValue(value);
	    this.setDeliverprice(deliverprice);
	    this.setStatus(status);
	    this.setDebt(deliverprice); 
	}


	public Pix() {
	}


	@Override
	public boolean invalidBalance() {
	
		return this.getValue() < this.getDebt();
	}
}
