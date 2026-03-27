package products;

import java.time.LocalDateTime;

import products_entities.Type;

public class Fitness extends Products{

	private LocalDateTime garantee = LocalDateTime.now();
	private String muscle_activation;
	private boolean eletrical;
	
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


	public String getMuscle_activation() {
		return muscle_activation;
	}


	public void setMuscle_activation(String muscle_activation) {
		this.muscle_activation = muscle_activation;
	}


	public boolean isEletrical() {
		return eletrical;
	}


	public void setEletrical(boolean eletrical) {
		this.eletrical = eletrical;
	}


	@Override
	public void validateType() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void restock(Double money) {
		// TODO Auto-generated method stub
		
	}}
