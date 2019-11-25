package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

	private Integer id;

	private String userName;

	private Integer passWord;

	private String job;

//	public Customer(String userName,Integer passWord,String job){
//		this.userName = userName;
//		this.passWord = passWord;
//		this.job = job;
//	}
}
