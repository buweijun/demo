package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Resource
	private EmpService empService;



	@RequestMapping("getEmp/{empno}")
	public ModelAndView getCustomer(@PathVariable int empno){

		ModelAndView mv = new ModelAndView();
		Emp emp = empService.findByNo(empno);
		mv.addObject("emp",emp);
		mv.setViewName("/emp/emp.html");
		return mv;
	 }





	@RequestMapping("/findemp")
	public ModelAndView findByName(HttpServletRequest req,@RequestParam(value = "name", defaultValue = "SMITH") String name) {
		ModelAndView mv = new ModelAndView();
		Emp emp = new Emp();
		emp = empService.findByName(name);
		mv.addObject("emp", emp);
		mv.setViewName("/user/emp.html");
		return mv;
	}





	@RequestMapping("/findEmpList")
	public ModelAndView findEmpList(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<Emp> emplist = new ArrayList();
		emplist = empService.findEmpList();
		mv.addObject("empList", emplist);
		mv.setViewName("/user/empList.html");
		return mv;
	}



	@RequestMapping("/testdb")
	public ModelAndView testdb(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String str = empService.testdb();
		mv.addObject("emp", str);
		mv.setViewName("/user/testdb.html");
		return mv;
	}


}
