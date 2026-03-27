package login;

public abstract class Account {

	private String fullname;
	private String email;
	private String password;
	private Integer cellphone;
	
	
	
	public Account(String fullname, String email, String password, Integer cellphone) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.cellphone = cellphone;
	}
	public String getUser() {
		return fullname;
	}
	public void setUser(String user) {
		this.fullname = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCellphone() {
		return cellphone;
	}
	public void setCellphone(Integer cellphone) {
		this.cellphone = cellphone;
	}
	
	
	
	
	
	
	
}
