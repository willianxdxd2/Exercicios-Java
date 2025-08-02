package entities;

public class ImportedProduct extends Product{
	private double customsFee;	
	public ImportedProduct(String name, Double price,Double customsFee) {
		super(name, price);
	}
	

	
	public double totalPrice() {
	
		return customsFee + price ;
		
	}

	public ImportedProduct() {
	
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}



	@Override
	public String toString() {
		return super.getName()  + "%" + totalPrice();
				
	}
	
	
}
