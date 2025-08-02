package entities;

public class outSourcedEmployee extends employee{
	private Double additonalCharger;
	
	public outSourcedEmployee(String name, Integer hours, Double valuePerHour, Double additonalCharger) {
		super(name, hours, valuePerHour);
		this.additonalCharger = additonalCharger;
	}



	public outSourcedEmployee() {
		super();
	}
	public Double getAdditonalCharger() {
		return additonalCharger;
	}
	public void setAdditonalCharger(Double additonalCharger) {
		this.additonalCharger = additonalCharger;
	}
	@Override
	public double payment() {
		
		return super.payment() +additonalCharger * 1.1;
		
	}	
}
