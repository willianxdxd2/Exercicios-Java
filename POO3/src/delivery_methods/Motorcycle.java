package delivery_methods;


import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import delivers.Order;
import entities.State;

public class Motorcycle extends Veihicle implements Shipping_Expenses{

	private String MotorCycle;
	private Order order;
	private LocalDateTime Will_Arrive;

	
	@Override
	public Boolean verifyDeliver(Order d) {
		
		if(this.getOrder().equals(d)) {
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
		
		Double mailtax = (this.getOrder().getPrice() * 0.08) + this.getOrder().getPrice();
		this.getOrder().setPrice(mailtax); 
		
	}
	@Override
	public void vehicle_type(Integer choose) {
		
		if(this.getKm() > 30) {
			System.out.println("This order cannot be deliverd at motocycle");
		}
		
		switch (choose) {
		case 1:
			System.out.println("Using Honda Pop 110i");
			this.setMotorCycle("Honda Pop 110i");
			this.setUseful_life(1500.0);
			this.setKm_per_liter(50);
			this.setTank_capacity(14);
			this.setMediumWeight(150);
			this.setKm_per_hour(93);
			
			break;
			
		case 2:
			System.out.println("Using Honda CH 160");
			this.setMotorCycle("Honda CH 160");
			this.setUseful_life(1000.0);
			this.setKm_per_liter(40);
			this.setTank_capacity(14);
			this.setMediumWeight(140);
			this.setKm_per_hour(135);
			break;
			
		case 3: 
			System.out.println("Using Kawasaki Ninja 400");
			this.setMotorCycle("Kawasaki Ninja 400");
			this.setUseful_life(850.0);
			this.setKm_per_liter(22);
			this.setTank_capacity(14);
			this.setMediumWeight(130);
			this.setKm_per_hour(190);
			break;
		}
	}
	
	
	public String getMotorCycle() {
		return MotorCycle;
	}
	public void setMotorCycle(String motorCycle) {
		MotorCycle = motorCycle;
	}
	@Override
	public void remaining_time() {
		
		
		
		Integer change = null;
		if(this.getMotorCycle() == "Honda Pop 110i") {
			change = this.getKm_per_hour() / this.getKm();
			
		}else if(this.getMotorCycle() == "Honda CH 160") {
			change = this.getKm_per_hour() / this.getKm();
		}else if(this.getMotorCycle() == "Kawasaki Ninja 400")
			change = this.getKm_per_hour() / this.getKm();
		
		this.setWill_Arrive(this.order.getOrdered_at().plusMinutes(change));
	}
	public LocalDateTime getWill_Arrive() {
		return Will_Arrive;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setWill_Arrive(LocalDateTime will_Arrive) {
		Will_Arrive = will_Arrive;
	}

	@Override
	public void validating_weight() {
		
		if (this.getOrder().getTotalweight() > this.getMediumWeight()) {
			System.out.println("its to heavy to use this delivery method");
		}
	}
	public Motorcycle(Double useful_life,Order order, LocalDateTime will_Arrive) {
		
		this.order = order;
		Will_Arrive = will_Arrive;
		validating_weight();
		remaining_time();
		mailTax();
	}
	
	
}