package exercicioComposição;
import entities.Product;
import entities.OrderItem;
public class Program {

	public static void main(String[] args){

		
	
		
		
		Product p = new Product("TV" , 1000.0);
		OrderItem oi1 = new OrderItem (1,1000.0,p) ;
		
		System.out.println(oi1);
		
		
	}

}
