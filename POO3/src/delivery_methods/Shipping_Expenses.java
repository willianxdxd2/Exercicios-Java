package delivery_methods;

import java.time.LocalDate;

import delivers.Order;

public interface Shipping_Expenses {

	public Boolean verifyDeliver(Order d);
	
	public void mailTax();
	
	public void remaining_time();
	
	public void vehicle_type(Integer choose);
	
	public void validating_weight();
	
}
