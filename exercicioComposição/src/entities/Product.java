package entities;

public class Product {

	String name;
	Double price;
	public Product(String name, Double price) {
		
		this.name = name;
		this.price = price;
	}
	public Product() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	
}
