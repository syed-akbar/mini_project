package login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DAOServiceImp implements DAOService {
	
	private Connection con = null;
	private Statement stmnt=null;

	@Override
	public void connectdb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "test");
		  stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifylogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values ('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listReg() {
		
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String email) {
		try {
			stmnt.executeUpdate("DELETE FROM registration WHERE email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(String name, String email) {
		try {
			stmnt.executeUpdate("UPDATE registration SET name='"+name+"' WHERE  email = '"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
		
		
	
	
	

}
