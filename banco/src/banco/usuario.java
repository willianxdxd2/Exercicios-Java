package banco;
import java.util.concurrent.ThreadLocalRandom;
public class usuario {
	private final int numconta = ThreadLocalRandom.current().nextInt(1000, 10000);
;
	public String  nome;
	private double deposito = 0;
	

public void setDeposito(double deposito) {
	this.deposito = deposito;
}
public double setDepositoSacar(double deposito) {
	return this.deposito =  deposito - 5;
}
public double getdeposito() {
	return deposito;
}
public int getnumconta() {
	return this.numconta;
}
}