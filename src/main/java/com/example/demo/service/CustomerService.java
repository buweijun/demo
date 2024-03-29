package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;

public interface CustomerService {

	public Customer findById(int id);

	public Customer findByUserName(String userName);


	public List<Customer> search(Customer customer);

//	public Customer findByUserName(String userName);


	public List<Customer> findCustomerList();


	public int newCustomer(Customer customer);

	public int updateCustomer(Customer customer);


	public String testdb();

	public void delete(int id);

}
