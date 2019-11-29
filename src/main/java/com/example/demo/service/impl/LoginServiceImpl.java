package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Permit;
import com.example.demo.entity.Role;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

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
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permit permissions1 = new Permit(1,"query");
        Permit permissions2 = new Permit(2,"add");
        Set<Permit> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role(1,"admin",permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        Customer customer1 = new Customer(1,"wsl","123456",roleSet);
        Map<String ,Customer> map = new HashMap<>();
        map.put(customer1.getUserName(), customer1);

        Permit permissions3 = new Permit(3,"query");
        Set<Permit> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role(2,"user",permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        Customer customer2 = new Customer(2,"zhangsan","123456",roleSet1);
        map.put(customer2.getUserName(), customer2);
        return map.get(userName);
	}

}
