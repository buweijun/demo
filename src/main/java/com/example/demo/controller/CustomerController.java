package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@Api(description = "Customer管理")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@ApiOperation(value = "获取info", notes = "获取info")
	@RequestMapping("getCustomer/{id}")
	public ModelAndView getCustomer(@PathVariable int id){
		ModelAndView mv = new ModelAndView();
		Customer customer = customerService.findById(id);
		mv.addObject("customer",customer);
		mv.setViewName("/customer/customer.html");
		return mv;
	 }


	@ApiOperation(value = "delete info", notes = "delete info")
	@GetMapping("deleteCustomer/{id}")
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



	@RequestMapping("searchCustomer")
	public ModelAndView searchCustomer(String userName,String job) {
		ModelAndView mv = new ModelAndView();
		Customer customer = new Customer();
		customer.setUserName(userName);
		customer.setJob(job);
		mv.addObject("customerList", customerService.search(customer));
		mv.setViewName("/customer/customerList.html");
		return mv;
	}


	@RequestMapping("/toNew")
	public ModelAndView toNew(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();

		Customer customer = new Customer();
		customer.setId(-1);
		customer.setJob("");
		//customer.setPassWord(null);
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
			System.out.println(">>>update >>>>>>>>>retInt--------->>   "+retInt);


		}else {
			retInt  = customerService.newCustomer(customer);
			System.out.println(">>>new >>>>>>>>>retInt--------->>   "+retInt);

		}



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
