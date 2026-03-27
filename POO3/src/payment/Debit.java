package payment;

import java.time.LocalDate;
import java.util.ArrayList;

import adm.DB_management;
import entities.Status;
import login.LocalTokenStorage;

public class Debit extends Charge implements PaymentService{
	@Override
	public void tax(Double value) {
		Double newValue = (this.getDebt()* 0.10) + this.getDebt();//Tax of 10% for debit
		this.setDebt(newValue);
	}
	public Debit() {
		super();
	}

	@Override
	public boolean invalidBalance() {
		return this.getValue() < this.getDebt();
	}
	@Override
	public void pay() {
		
		String tokenlogin = LocalTokenStorage.read();
		Integer id = DB_management.getUserIdByToken(tokenlogin);
		String user = DB_management.selectname(id);
		

		if(this.getIdentifier().equals(user) && this.getStatus() == Status.PENDING_PAYMENT && !invalidBalance()) {
			
			
		
			System.out.println("Default debt: " + this.getDebt());
			tax(this.getDebt());
			System.out.println("The Debt: " + this.getDebt() + " plus 10% Tax on debit");
			Double newvalue = this.getValue() - this.getDebt();
			System.out.println("Debt paid Successfully!");
			System.out.println("Your balance is: " + newvalue);
		}
		
	}

	public Debit(String identifier, Double value, Double deliverprice, Status status) {
	    this.setIdentifier(identifier);
	    this.setValue(value);
	    this.setDeliverprice(deliverprice);
	    this.setStatus(status);
	    this.setDebt(deliverprice); 
	}
}
