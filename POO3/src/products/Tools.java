package products;

import java.time.LocalDateTime;

import products_entities.Section;
import products_entities.Type;

public class Tools extends Products{

	private LocalDateTime garantee = LocalDateTime.now();
	private Section section;
	private String Material_type;
	private boolean eletrical;
	private String wats;
	private boolean Ergonomic;
	@Override
	public void garantee() {
		
		if(this.getType().equals(Type.Common) || this.getType().equals(Type.Imported)) {
			garantee.plusDays(30);
		}
		
	}
	
}
