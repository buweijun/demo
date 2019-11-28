package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Permit {


	private Integer id;

	private String permitName;

	public Permit(Integer id, String permitName) {
		this.id=id;
		this.permitName=permitName;
	}


}
