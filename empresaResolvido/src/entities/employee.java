package entities;

public class employee {
	private String name;
	private Integer Hours;
	private Double valuePerHour;
	public employee() {
	}
	public employee(String name, Integer hours, Double valuePerHour) {
	
		this.name = name;
		Hours = hours;
		this.valuePerHour = valuePerHour;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHours() {
		return Hours;
	}
	public void setHours(Integer hours) {
		Hours = hours;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	
	public double payment() {
		
		return Hours * valuePerHour;
	}
	
	
	
}
