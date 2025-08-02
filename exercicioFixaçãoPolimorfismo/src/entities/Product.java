package entities;

public class Product {

	private String name;
	protected Double price;
	
	public String priceTag (char c) {
		if (c == 'c') {
			return "Common";
		}
		else if (c == 'u') {
			return "Used";
		}
		else if (c == 'i') {
			return "Imported";
		}
		else {
			return "no tag";
		}
	}

	@Override
	public String toString() {
		return name + " Price" + price;
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
