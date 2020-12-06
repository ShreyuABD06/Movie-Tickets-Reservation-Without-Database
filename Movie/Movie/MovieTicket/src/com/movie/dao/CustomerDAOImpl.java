package com.movie.dao;
import java.util.ArrayList;

import com.movie.domain.Cast;
import com.movie.domain.Customer;
import com.movie.domain.Movie;
import com.movie.domain.Show;
import com.movie.domain.Theatre;

public class CustomerDAOImpl implements CustomerDAO {
	
	ArrayList<Customer> customers=new ArrayList<Customer>() ;
	@Override
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	@Override
	public String RegisterCustomer(Customer customer) {
		for(Customer m:customers) {
			if(m.getEmail().equals(customer.getEmail())) {
				return null;
			}
		}
		customers.add(customer);
		return "Customer Registered";
	}

	@Override
	public String UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String DeleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomerByEmail(String email) {
		for(Customer c:customers) {
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

}
