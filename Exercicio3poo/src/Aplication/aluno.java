package Aplication;

public class aluno {
	
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	
	
	public double notafinal(){
		
		return nota1 + nota2 + nota3;
	}
	
	public String toString() {
		
		
		
		if (this.notafinal() > 60) {
			return "pass";
		}
		else {
			return "failed";
		}
		
		 
	}
	
}
