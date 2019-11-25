package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@RequestMapping("getCustomer/{id}")
	public ModelAndView getCustomer(@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		Customer customer = customerService.findById(id);
		mv.addObject("customer",customer);
		mv.setViewName("/customer/customer.html");
		return mv;
	 }



	@RequestMapping("deleteCustomer/{id}")
	public ModelAndView deleteCustomer(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		customerService.delete(id);
		mv.addObject("customerList", customerService.findCustomerList());
		mv.setViewName("/customer/customerList.html");
		return mv;
	}


	@RequestMapping("/findCustomerList")
	public ModelAndView findEmpList(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerList", customerService.findCustomerList());
		mv.setViewName("/customer/customerList.html");
		return mv;
	}




	@RequestMapping("/toNew")
	public ModelAndView toNew(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();

		Customer customer = new Customer();
		customer.setId(-1);
		customer.setJob("");
		customer.setPassWord(0);
		customer.setUserName("");
		mv.addObject("customer",customer);
		mv.setViewName("/customer/newCustomer.html");
		return mv;
	}



	@RequestMapping("/toUpdate/{id}")
	public ModelAndView toUpdate(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		Customer customer = customerService.findById(id);
		mv.addObject("customer",customer);
		mv.setViewName("/customer/newCustomer.html");
		return mv;
	}

	//new or update
	@RequestMapping("/newCustomer")
	public ModelAndView newCustomer(Integer id,String userName,Integer passWord,String job) {
		ModelAndView mv = new ModelAndView();
		Customer customer = new Customer();
		customer.setJob(job);
		customer.setPassWord(passWord);
		customer.setUserName(userName);

		int retInt = -1;

		if(id !=null&& id !=-1 && id !=0) {
			customer.setId(id);
			retInt = customerService.updateCustomer(customer);
		}else {
			retInt  = customerService.newCustomer(customer);
		}

		System.out.println(">>>>>>>>>>>>retInt--------->>   "+retInt);

		mv.addObject("customerList", customerService.findCustomerList());
		mv.setViewName("/customer/customerList.html");
		return mv;
	}







	@RequestMapping("/testdb")
	public ModelAndView testdb(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String str = customerService.testdb();
		mv.addObject("emp", str);
		mv.setViewName("/user/testdb.html");
		return mv;
	}


}
