package com.movie.bo;

import com.movie.dao.AdminValidateDAO;

public class AdminValidateBO {
AdminValidateDAO dao=new AdminValidateDAO();

public boolean adminValidate(String username, String password) {
	return dao.adminValidate(username, password);
}

}
