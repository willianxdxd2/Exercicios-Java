package products;

import java.time.LocalDateTime;

import products_entities.Section;
import products_entities.Type;

public class Technology extends Products{

	private LocalDateTime garantee = LocalDateTime.now();
	private Section section;
	private String conectionType;
	private Integer volts;
	

	public Technology(LocalDateTime garantee, Section section, String conectionType, Integer volts) {
		super();
		this.garantee = garantee;
		this.section = section;
		this.conectionType = conectionType;
		this.volts = volts;
		garantee();
	}


	@Override
	public void garantee() {
		
		if(this.getType().equals(Type.Common) || this.getType().equals(Type.Imported)) {
			garantee.plusDays(90);
		}
		
	}



	public LocalDateTime getGarantee() {
		return garantee;
	}



	public void setGarantee(LocalDateTime garantee) {
		this.garantee = garantee;
	}
	
}
