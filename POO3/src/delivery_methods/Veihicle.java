package delivery_methods;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Veihicle implements Deliver_expenses{

	
	private Double useful_life;
	protected Integer tank_capacity;
	private Integer km_per_liter;
	protected Integer km;
	private double tank = tank_capacity;
	private Integer mediumWeight;
	private Integer km_per_hour;

	
	public Integer getMediumWeight() {
		return mediumWeight;
	}
	public void setMediumWeight(Integer mediumWeight) {
		this.mediumWeight = mediumWeight;
	}
	public Integer getKm_per_hour() {
		return km_per_hour;
	}
	public void setKm_per_hour(Integer km_per_hour) {
		this.km_per_hour = km_per_hour;
	}

	private static final double GAS_PRICE = 6.0;
	private static final int ROUND_TRIP = 2;
	
	public void deterioration() {
		Integer distance = this.getKm();
		double numero = Math.random();
		 for(int i = 0 ; i <= distance ; i++) {
			 numero = (int) (Math.random() * 10) / 10.0;
			 this.setUseful_life(getUseful_life() - numero); 
		 }
	}
	
	public void oneRound() {
			
		Double liters = (double) (this.getKm() / this.getKm_per_liter());
		Double price = (liters * GAS_PRICE) * ROUND_TRIP;
		System.out.println("price per route is: " + price);
		this.setTank(this.getTank() - liters);
		System.out.println("Remaining fuel: " + this.getTank());
		deterioration();
	}
	public Double getUseful_life() {
		return useful_life;
	}
	public void setUseful_life(Double useful_life) {
		this.useful_life = useful_life;
	}
	
	public Veihicle(Integer tank_capacity, Integer km_per_liter, Integer km, Double useful_life) {
		this.tank_capacity = tank_capacity;
		this.km_per_liter = km_per_liter;
		this.km = km;
		this.useful_life = useful_life;
	}
	public Veihicle() {
	}
	public void Refuel(Double money) {
		if(this.getTank() < (this.getKm() / this.getKm_per_liter())) {
			System.out.println("Need refuel");
			Double total_refuel= (this.getTank() - this.getTank_capacity()) * GAS_PRICE;
			if(money >= total_refuel) {
				
				Double remaining = this.getTank() - this.getTank_capacity();
				this.setTank(remaining + this.getTank());
				
				System.out.println("Tank totally fueled!");
				Double change = money - total_refuel;
				System.out.println("Your change is " + change);
			}
		}
	}

	public Integer getTank_capacity() {
		return tank_capacity;
	}

	public void setTank_capacity(Integer tank_capacity) {
		this.tank_capacity = tank_capacity;
	}

	public void setTank(double tank) {
		this.tank = tank;
	}
	
	public Double getTank() {
		return tank;
	}

	public Integer getKm_per_liter() {
		return km_per_liter;
	}
	public void setKm_per_liter(Integer km_per_liter) {
		this.km_per_liter = km_per_liter;
	}

	public static double getGasPrice() {
		return GAS_PRICE;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}
}
