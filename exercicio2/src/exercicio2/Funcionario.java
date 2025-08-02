package exercicio2;

public class Funcionario {
	public String nome;
	public double salbruto;
	public double taxa;
	
	public double liquido(){
		
		return salbruto - taxa;
	}
	public void aumento(double porcentagem){
	
		salbruto += salbruto  * porcentagem/ 100.0;
	}
	
	public String toString() {
		
		return nome + " ," + String.format("%.2f" , this.liquido());
		
	}
}
