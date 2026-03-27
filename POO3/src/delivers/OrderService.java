package delivers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import delivery_methods.Veihicle;
import payment.Charge;
import products.Products;

public class OrderService extends Order implements OrderArguments{
	
	private Charge ch;
	private Boolean next;
	private LocalDateTime delivery_time;
	private Veihicle v;
	
	public Charge getCh() {
		return ch;
	}

	public void setCh(Charge ch) {
		this.ch = ch;
	}

	public Boolean getNext() {
		return next;
	}

	public void setNext(Boolean next) {
		this.next = next;
	}


	@Override
	public void deliverprice() {
				
	}

	public OrderService(String user, ArrayList<Products> prlist, Long cpf, Charge ch, Boolean next,
			LocalDateTime delivery_time) {
		super();
		this.ch = ch;
		this.next = next;
		this.delivery_time = delivery_time;
	}
	@Override
	public Boolean cpf_validation(String cpf) {
	
		cpf = cpf.replaceAll("\\D", "");
		if(cpf.length() != 11) {
			return false;
		}
		if(cpf.chars().distinct().count() == 1) {
			return false;
		}
		int[]cpfArray = new int[11];
		for(int i = 0;i<11;i++){
			cpfArray[i] = Character.getNumericValue(cpf.charAt(i));
		}
		
		int sum1 = 0;
		
		for (int i = 0 , weight = 10; i < 9;i++,weight--) {
			sum1 += cpfArray[i] * weight;
		}
		
		int firstDigit = (sum1 * 10) % 11;
		if (firstDigit == 10 ) firstDigit = 0;
		
		int sum2 = 0 ;
		
		for (int i = 0,weight = 11 ; i < 10 ; i++, weight--) {
			sum2 += cpfArray[i] * weight;
		}
		
		int secondDigit = (sum2*10) % 11;
		if(secondDigit == 10)secondDigit = 0;
		
		return cpfArray[9] == firstDigit && cpfArray[10] == secondDigit;
		
	}

	@Override
	public void gasolinplus() {
		// TODO Auto-generated method stub
		
	}
	public Veihicle getV() {
		return v;
	}

	public void setV(Veihicle v) {
		this.v = v;
	}

	@Override
	public String toString() {
		
		return "User: " + this.getUser() + " Products: " + this.getPrlist() + " CPF: " + this.getCpf() + " State: " + this.getState() +
				" Total price: " + this.getDeliverprice() + " Payment type: " + this.getCh() + " Total Weight: " + this.getTotalweight();
		
	}




	@Override
	public String cart() {
		
		for(Products p : this.getPrlist()) {
			
			return p.getProduct_name();
		}
		return null;
	}

	@Override
	public void choose_delivery_method() {
		// TODO Auto-generated method stub
	}
	
	public OrderService() {

	}
	
	
	
}
