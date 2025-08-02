package entities;

import java.util.Date;

public class HourContract {

	private Date date;
	private Double valueperhour;
	private Integer Hours;
	
	public HourContract() {
}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValueperhour() {
		return valueperhour;
	}

	public void setValueperhour(Double valueperhour) {
		this.valueperhour = valueperhour;
	}

	public Integer getHours() {
		return Hours;
	}

	public void setHours(Integer hours) {
		Hours = hours;
	}

	public double TotalValue() {
		return  valueperhour * Hours;
	}
	
	
	public HourContract(Date date, Double valueperhour, Integer hours) {

		this.date = date;
		this.valueperhour = valueperhour;
		Hours = hours;
	}}
