package com.example.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Emp;
import com.example.demo.entity.TestDB;

@Repository
public class EmpDao {

	@Resource
	private JdbcTemplate jdbcTemplate;


	public Emp findByName(String username){
//        String sql = "select empno,ename,job,deptno from emp where ename = ?";

        String sql = "select empno,ename,job,deptno from emp";

		RowMapper rowMapper = (RowMapper) new BeanPropertyRowMapper(Emp.class);
//		List empList = jdbcTemplate.queryForList(sql, new Object[] { username }, rowMapper);

		List empList = jdbcTemplate.query(sql, rowMapper);


		System.out.println(">>>>>>>>>>>>>>>>>"+empList.get(0).toString());

		return (Emp)empList.get(0);

    }



	public List<Emp> findEmpList(){
        String sql = "select empno,ename,job,deptno from emp";
		RowMapper rowMapper = (RowMapper) new BeanPropertyRowMapper(Emp.class);
		List empList = jdbcTemplate.query(sql, rowMapper);
		System.out.println(">>>>>>>>>>>>>>>>>"+empList.get(0).toString());
		return empList;
    }




	public String testdb() {
        String sql = "select 33 as haha from dual";
		RowMapper rowMapper = (RowMapper) new BeanPropertyRowMapper(TestDB.class);
		//List empList = jdbcTemplate.queryForList(sql);
		List testList = jdbcTemplate.query(sql, rowMapper);
		return testList.get(0).toString();


	}
}
