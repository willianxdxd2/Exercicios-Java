package products;

import products_entities.Section;
import products_entities.Type;

public abstract class Products implements Product_Expenses{

	
	private Integer id;
	private String product_name;
	private String mark;
	private Double productprice;
	private Double weight;
	private Integer quantity;
	private Integer quantity_in_stock;
	private Type type;
	private String description;
	
	public Products(Integer id, String product_name, String mark, Double productprice, Double weight, Integer quantity,
			Integer quantity_in_stock, Type type, String description) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.mark = mark;
		this.productprice = productprice;
		this.weight = weight;
		this.quantity = quantity;
		this.quantity_in_stock = quantity_in_stock;
		this.type = type;
		this.description = description;
	}
	
	
	public Products() {
	}

	private final Integer stock_capacity = null;
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public Double getProductprice() {
		return productprice;
	}

	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Override
	public void validateType() {
		if(this.getType().equals(Type.Imported)) {
			this.setProductprice(getProductprice() * 0.10 + this.getProductprice());
			//importation tax
		}
		if(this.getType().equals(type.Used)) {
			this.setProductprice(this.getProductprice() * 0.10 - this.getProductprice());
			//cheapen for used product
		}
		
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public void restock(Double money) {
		if(this.getQuantity_in_stock() <= 5) {
			System.out.println("Need restock");
			Double price = this.getStock_capacity() - this.getQuantity_in_stock() * this.getProductprice();
			Integer rest = this.getStock_capacity() - this.getQuantity_in_stock();
			if(money >= price) {
				System.out.println("Products restocked");
				this.setQuantity_in_stock(rest);
			}else {
				System.out.println("Invalid balance");
			}
		}
		
	}

	public Integer getStock_capacity() {
		return stock_capacity;
	}

	public Integer getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setQuantity_in_stock(Integer quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	
}
