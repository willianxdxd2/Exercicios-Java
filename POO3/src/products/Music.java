package products;

import java.time.LocalDateTime;

import products_entities.Type;

public class Music extends Products{

	private LocalDateTime garantee = LocalDateTime.now();
	private String color;
	private boolean eletrical;
	private int strings;
	
	
	
	@Override
	public void garantee() {
		
		if(this.getType().equals(Type.Common) || this.getType().equals(Type.Imported)) {
			garantee.plusDays(90);
		}
		
	}

}
