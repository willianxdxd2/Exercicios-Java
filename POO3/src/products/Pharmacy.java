package products;

import java.time.LocalDate;
import java.time.LocalDateTime;

import products_entities.Type;

public class Pharmacy extends Products{

	private LocalDateTime garantee = LocalDateTime.now();
	private int pills;
	private LocalDate expiration_date;
	private String Indication;
	private String Contraindication;
	
	
	@Override
	public void garantee() {
		
		if(this.getType().equals(Type.Common) || this.getType().equals(Type.Imported)) {
			garantee.plusDays(90);
		}
		
	}
	
}
