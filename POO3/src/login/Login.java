package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import adm.DB_management;

public class Login extends Account implements Account_system{

	
	public Login(String fullname, String email, String password, Integer cellphone) {
		super(fullname, email, password, cellphone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verifypassword(String password) {
		Integer ultimoid = DB_management.searchLastId();
		for(int i = 0 ; i <= ultimoid;i++) {
			
			String nome = DB_management.searchfield("password",i);

			if(password.equals(nome)){
				return true;
			}
		}
		return false;
	}
	
	public void login(String fullname, String password, String email) {

	    if (verifyuser(fullname) && verifypassword(password) && verifyemail(email)) {

	        System.out.println("Account logged successfully!");

	
	        String token = UUID.randomUUID().toString();

	        Timestamp expiresAt = Timestamp.valueOf(
	            LocalDateTime.now().plusDays(7)
	        );

	        Integer userId = DB_management.getUserIdByEmail(email);

	        DB_management.saveToken(userId, token, expiresAt);

	        LocalTokenStorage.save(token);

	    } else {

	        System.out.println("Error on login");

	        if (!verifyuser(fullname)) {
	            System.out.println("User do not match");
	        }
	        if (!verifypassword(password)) {
	            System.out.println("Password do not match");
	        }
	        if (!verifyemail(email)) {
	            System.out.println("Email do not match or invalid email");
	        }
	    }
	}
	public boolean isLogged() {
	    String token = LocalTokenStorage.read();
	    return token != null && DB_management.isTokenValid(token);
	}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
