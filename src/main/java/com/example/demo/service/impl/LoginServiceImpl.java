package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Permit;
import com.example.demo.entity.Role;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	CustomerMapper customerMapper;


	@Override
	public Customer getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName(getMapByName);
	}

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
	private Customer getMapByName(String userName) {
        //添加用户
        //admin有query和add权限，common user只有一个query权限

		Map<String ,Customer> map = new HashMap<>();

        Permit permissions1 = new Permit(1,"query");
        Permit permissions2 = new Permit(2,"add");
        Set<Permit> adminPermissionsSet = new HashSet<>();
        adminPermissionsSet.add(permissions1);
        adminPermissionsSet.add(permissions2);
        Role adminRole = new Role(1,"admin",adminPermissionsSet);
        Set<Role> adminRoleSet = new HashSet<>();
        adminRoleSet.add(adminRole);

        Permit permissions3 = new Permit(3,"query");
        Set<Permit> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role userRole = new Role(2,"user",permissionsSet1);
        Set<Role> commonRoleSet = new HashSet<>();
        commonRoleSet.add(userRole);


        Customer customer = customerMapper.findByUserName(userName);
        if("admin".equals(customer.getUserName())){
        	customer.setRoles(adminRoleSet);
        }else {
        	customer.setRoles(commonRoleSet);
        }

        map.put(customer.getUserName(), customer);
        return map.get(userName);
	}

}
