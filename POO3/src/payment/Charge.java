package payment;

import java.util.ArrayList;
import java.util.Random;

import delivers.Order;
import entities.Status;
import products.Products;
public abstract class Charge extends Order implements PaymentService{
	
	private String identifier;
	private Double value;
	private Status status;
	public Double debt;
	
	public Double getDebt() {
		return debt;
	}
	public void setDebt(Double newValue) {
		this.debt = newValue;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	
	
	
	public Charge(String identifier, Double value,
			Status status, Double debt) {
		this.identifier = identifier;
		this.value = value;
		this.status = status;
		this.debt = this.getDeliverprice();
		this.setDebt(this.getDeliverprice());
	}
	public Charge() {
	}
	public void pay() {

		if(this.identifier != null && this.status == Status.PENDING_PAYMENT && this.value > this.debt) {
			Double newvalue = value - this.getDebt();
			System.out.println("Debt paid Successfully!");
			System.out.println("Your balance is: " + newvalue);
		}
		
	}
	public String toString() {
		
		return "Identifier: " +this.getIdentifier() + " Value Payment: " + this.getValue() + " Status Type: " + this.getStatus(); 
	}
	public void pay(Integer token) {
		// TODO Auto-generated method stub
		
	}
	public void generateToken() {
	}
}