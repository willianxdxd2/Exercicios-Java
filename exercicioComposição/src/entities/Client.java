package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String nameClient;
	String emailClient;
	Date birthDate;
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	public Client() {
		
	}
	@Override
	public String toString() {
		return "Client [nameClient=" + nameClient + ", emailClient=" + emailClient + ", birthDate=" + birthDate + "]";
	}
	public Client(String nameClient, String emailClient, Date birthDate) {
		super();
		this.nameClient = nameClient;
		this.emailClient = emailClient;
		this.birthDate = birthDate;
	}
	public String getEmailClient() {
		return emailClient;
	}
	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
