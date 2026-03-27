package login;

import adm.DB_management;

public interface Account_system {

	
	public default boolean verifyemail(String email) {
		Integer ultimoid = DB_management.searchLastId();
		for(int i = 0 ; i <= ultimoid;i++) {
			
			String nome = DB_management.searchfield("email",i);

			if(email.equals(nome) && email.contains("@")){
				return true;
			}
		}
		return false;
	}
	public boolean verifypassword(String password);

	public default boolean verifyuser(String fullname) {
		Integer ultimoid = DB_management.searchLastId();
			for(int i = 0 ; i <= ultimoid;i++) {
				
				String nome = DB_management.searchfield("name",i);

				if(fullname.equals(nome)){
					return true;
				}
			}
			return false;
	}
	
	
}
