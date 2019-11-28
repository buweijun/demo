package com.example.demo.entity;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {



	private Integer id;

	private String roleName;


	private Set<Permit> permits;

	public Role(Integer id, String roleName, Set<Permit> permitsSet) {
		this.id=id;
		this.roleName=roleName;
		this.permits=permitsSet;
	}


}
