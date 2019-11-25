package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Emp;

public interface EmpService {


	public Emp findByNo(int empno);

	public Emp findByName(String username);


	public List<Emp> findEmpList();

	public String testdb();
}
