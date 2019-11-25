package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmpDao;
import com.example.demo.entity.Emp;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {


	@Resource
	private EmpDao empDao;


	@Autowired
	EmpMapper empMapper;
	
	
	
	@Override
	public Emp findByNo(int empno) {
		// TODO 自動生成されたメソッド・スタブ
		return empMapper.findByNo(empno);
	}





	@Override
	public Emp findByName(String name) {
		return empDao.findByName(name);
	}





	@Override
	public List<Emp> findEmpList() {

		return empDao.findEmpList();
	}





	@Override
	public String testdb() {

		return empDao.testdb();
	}



}
