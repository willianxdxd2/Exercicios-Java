package entities;
import java.text.SimpleDateFormat;
import java.util.Date;
public class UsedProduct extends Product {

	protected Date manufactureDate;

	public UsedProduct() {
		
	}
	
	public String convertedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		return sdf.format(manufactureDate);
	}
	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String toString() {
		return  super.toString() + " Date:  " + convertedDate() ;
	} 
	
}
