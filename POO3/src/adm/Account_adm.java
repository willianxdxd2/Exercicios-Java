package adm;

import login.Account;
import login.Account_system;

public class Account_adm extends Account implements Account_system{

	public Account_adm(String user, String email, String password, Integer cellphone) {
		super(user, email, password, cellphone);
		// TODO Auto-generated constructor stub
	}

	//@Override
	public boolean verifyemail() {
		// TODO Auto-generated method stub
		return false;
	}
	//@Override
	public boolean verifypassword() {
	
		
		return false;
		
		
	}

	//@Override
	public boolean verifyuser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifypassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
