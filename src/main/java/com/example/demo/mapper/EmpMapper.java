package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Emp;

@Repository
public interface EmpMapper {
	
	Emp findByNo(int empNo);
}
