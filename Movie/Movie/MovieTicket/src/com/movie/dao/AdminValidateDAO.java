package com.movie.dao;

public class AdminValidateDAO {
public AdminValidateDAO() {
	
}
public Boolean adminValidate(String username,String password) {
	if(username.equals("admin") || password.equals("12345")) {
		return true;
	}
	return false;
}
}
