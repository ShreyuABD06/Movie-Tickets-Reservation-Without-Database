package com.movie.dao;

import java.util.ArrayList;

import com.movie.domain.Customer;

public interface CustomerDAO {
	public ArrayList<Customer> getCustomers();
	public String RegisterCustomer(Customer customer);
	public String UpdateCustomer(Customer customer);
	public String DeleteCustomer(Customer customer);
	public Customer getCustomerByEmail(String email);
}
