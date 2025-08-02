package dados;

public class Dados {
	private int numConta;
	public String name;
	private double deposito;
	public Dados(int numConta, String name, double deposito) {
		
		this.numConta = numConta;
		this.name = name;
		this.deposito = deposito;
		
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDeposito() {
		return deposito;
	}
	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}
	
	public void exibirDados() {
		
		System.out.println("Conta: " + numConta + "Nome: " + name + "deposito: " + deposito);
		
		
	}
	
	
	
	{	
	}
	
}
