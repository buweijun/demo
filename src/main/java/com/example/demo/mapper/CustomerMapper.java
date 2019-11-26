package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerMapper {


	Customer findById(int id);

	Customer findByUserName(String userName);

	List<Customer> search(Customer customer);

	List<Customer> findCustomerList();

	int insert(Customer customer);

	int update(Customer customer);

	void delete(int id);


}
