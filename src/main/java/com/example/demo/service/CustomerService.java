package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {

	public Customer findById(int id);

	public List<Customer> findCustomerList();


	public int newCustomer(Customer customer);

	public String testdb();

	public void delete(int id);

}
