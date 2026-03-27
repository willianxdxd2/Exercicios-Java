package payment;

import java.time.LocalDate;
import java.util.ArrayList;

import adm.DB_management;
import entities.Status;
import login.LocalTokenStorage;

public class Credit  extends Charge implements PaymentService{
	
	@Override
	public void pay() {
		String tokenlogin = LocalTokenStorage.read();
		Integer id = DB_management.getUserIdByToken(tokenlogin);
		String user = DB_management.selectname(id);

		if(this.getIdentifier().equals(user) && this.getStatus() == Status.PENDING_PAYMENT && !invalidBalance()) {
			System.out.println("Default debt: " + this.getDebt());
			tax(this.getDebt());
			System.out.println("Debt: " + this.getDebt() + " plus 25% Tax on credit");
			Double newvalue = this.getValue() - this.getDebt();
			this.setValue(newvalue);
			System.out.println("Debt paid Successfully!");
			System.out.println("Your balance is: " + newvalue);
		}
		
	}
	
	public Credit(String identifier, Double value, Double deliverprice, Status status) {
	    this.setIdentifier(identifier);
	    this.setValue(value);
	    this.setDeliverprice(deliverprice);
	    this.setStatus(status);
	    this.setDebt(deliverprice); 
	}
	@Override
	public void tax(Double value) {
		Double newValue = (this.getDebt()) * 0.25 + this.getDebt();//tax of 25% for credit
		this.setDebt(newValue);
	}
	
	public Credit() {
		super();
	}

	@Override
	public boolean invalidBalance() {
		return this.getValue() < this.getDebt();
	}
	
}
