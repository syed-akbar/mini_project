package login.service;

import java.sql.ResultSet;


public interface DAOService {
	
	public void connectdb();
	
	public boolean verifylogin(String email,String password);

	public void saveReg(String name, String city, String email, String mobile);

	public ResultSet listReg();

	public void delete(String email);

	public void update(String name, String email);

	

}
