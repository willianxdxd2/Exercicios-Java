package delivers;

import java.time.LocalDateTime;
import java.util.ArrayList;

import entities.State;
import payment.Charge;
import products.Products;

public abstract class Order{

	private String user;
	private ArrayList<Products> prlist = new ArrayList<>();
	private String cpf;
	private State state;
	private Double deliverprice;
	private Double totalweight;
	private final LocalDateTime ordered_at = LocalDateTime.now();

	public Double getTotalweight() {
		return totalweight;
	}
	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}
	public LocalDateTime getOrdered_at() {
		return ordered_at;
	}
	public Double getPrice() {
		return deliverprice;
	}
	public void setPrice(Double price) {
		this.deliverprice = price;
	}

	
	public void deliverPrice() {
		Double sum = 0.0;
		for(Products p: prlist) {
			sum = sum + p.getProductprice() * p.getQuantity();
		}
		this.setDeliverprice(sum);
	}
	
	public void totalWeight() {
		for(Products p : this.getPrlist()) {
			
			Double sum =+ p.getQuantity() * p.getWeight();
			
			this.setTotalweight(sum);
		}
		
	}
	public Double getDeliverprice() {
		return deliverprice;
	}
	public void setDeliverprice(Double deliverprice) {
		this.deliverprice = deliverprice;
	}
	
	
	public ArrayList<Products> getPrlist() {
		return prlist;
	}
	public void setPrlist(ArrayList<Products> prlist) {
		this.prlist = prlist;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

}
