package delivery_methods;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import delivers.Order;
import entities.State;
import payment.Charge;

public class Utiliary_car extends Veihicle implements Shipping_Expenses{

	

	private String carrier;
	private Order deliver;
	private LocalDate will_arrive;
	private Charge ch;
	private Integer mediumWeight;
	
	
	public Integer getMediumWeight() {
		return mediumWeight;
	}

	public void setMediumWeight(Integer mediumWeight) {
		this.mediumWeight = mediumWeight;
	}

	public Utiliary_car(Integer tank_capacity, Integer km_per_liter, Integer km, double tank) {
		super(tank_capacity, km_per_liter, km, tank);
		this.setKm(ThreadLocalRandom.current().nextInt(30,80));
	}

	@Override
	public Boolean verifyDeliver(Order d) {
		
		if(this.getDeliver().equals(d)) {
			System.out.println("Deliver On_route");
			d.setState(State.On_route);
			return true;
		}else {
			System.out.println("Deliver Cancelled");
			d.setState(State.Canceled);
			return false;
		}
	}

	@Override
	public void mailTax() {
		
		Double mailtax = (this.getDeliver().getPrice() * 0.08) + this.getDeliver().getPrice();
		this.getDeliver().setPrice(mailtax); 
	}
	
	public void vehicle_type(Integer choose) {
		
		switch (choose) {
		case 1:
			System.out.println("");
			this.setCarrier("");
			this.setKm_per_liter(50);
			this.setTank_capacity(4);
			this.setMediumWeight(150);
			
			
			break;
			
		case 2:
			System.out.println("");
			this.setCarrier("");
			this.setKm_per_liter(50);
			this.setTank_capacity(4);
			this.setMediumWeight(150);
			break;
			
		case 3: 
			System.out.println("");
			this.setCarrier("");
			this.setKm_per_liter(50);
			this.setTank_capacity(4);
			this.setMediumWeight(150);
			break;
		}
			
	}
	
	@Override
	public void remaining_days() {
	
		
		
		
		
		
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Order getDeliver() {
		return deliver;
	}

	public void setDeliver(Order deliver) {
		this.deliver = deliver;
	}

	public LocalDate getWill_arrive() {
		return will_arrive;
	}

	public void setWill_arrive(LocalDate will_arrive) {
		this.will_arrive = will_arrive;
	}

	@Override
	public void validating_weight() {
		// TODO Auto-generated method stub
		
	}

	
}
