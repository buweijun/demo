package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmpDao;
import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Resource
	private EmpDao empDao;

	@Autowired
	CustomerMapper customerMapper;


	@Override
	public Customer findById(int id) {
		return customerMapper.findById(id);
	}




	@Override
	public List<Customer> search(Customer customer) {
		return customerMapper.search(customer);
	}




	/*	@Override
		public Customer findByUserName(String userName) {
			return customerMapper.findByUserName(userName);
		}*/



	@Override
	public List<Customer> findCustomerList() {

		return customerMapper.findCustomerList();
	}


	@Override
	public int newCustomer(Customer customer) {
		return customerMapper.insert(customer);
	}




	@Override
	public int updateCustomer(Customer customer) {
		return customerMapper.update(customer);
	}


	@Override
	public void delete(int id) {
		customerMapper.delete(id);
	}


	@Override
	public String testdb() {

		return empDao.testdb();
	}



}
