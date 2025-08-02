package entities;

public class empregado {
	Integer id;
	String nome;
	double Salario;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	
	@Override
	public String toString() {
		return "empregado [id=" + id + ", nome=" + nome + ", Salario=" + Salario + "]";
	}
	public void getId(int aumento) {
		// TODO Auto-generated method stub
		
	}
	
	
}
