package com.movie.bo;

import com.movie.dao.CustomerDAOImpl;
import com.movie.domain.Customer;

public class CustomerBO {
CustomerDAOImpl dao=new CustomerDAOImpl();
	public String registerCustomer(Customer customer) {
		return dao.RegisterCustomer(customer);
	}
	public Customer getCustomerByEmail(String email) {
		return dao.getCustomerByEmail(email);
	}

}
