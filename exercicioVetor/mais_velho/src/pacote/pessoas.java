package pacote;

public class pessoas {
	
	String nome ;
	int idade;
	public pessoas() {
		this.nome = "";
		this.idade = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "Nome: " + nome + " idade: " + idade;
	}
	
}
