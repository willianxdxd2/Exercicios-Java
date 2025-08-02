package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
	private Integer quantity; 
	private Double price;
	private Product product = new Product();
	List <Product> products = new ArrayList<>();
	
	public OrderItem(Integer quantity, Double price, Product product) {
		
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		
	}
	public void add() {
		products.add(product);
	}
	public void remove() {
		products.remove(product);
	}
	public Double subTotal() {
		return price * quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public Product getProduct() {
		return product;
	}

	public OrderItem() {
		
	}
	
	@Override
	public String toString() {
		return getProduct().getName()
				+ " , $"
				+ String.format("%.2f", price)
				+ ", Quantity"
				+ quantity
				+ " , Subtotal: $"
				+ String.format("%.2f", subTotal() );
	}
	 
}
