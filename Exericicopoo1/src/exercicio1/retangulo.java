package exercicio1;

public class retangulo {
	public double a;
	public double b;

public double area(){
	
	return a * b;
}
 public double perimetro(){
	
	return a*2 + b*2;
}
 public double diagonal(){
	double c;
	c = Math.pow(a,2.0) + Math.pow(b,2.0);
	return Math.pow(c,2.0);
	
	}
}