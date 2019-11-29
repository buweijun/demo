package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.CustomerService;

@RestController
public class LoginController {




	@Autowired
	CustomerMapper customerMapper;


	@Resource
	private CustomerService customerService;

    @RequestMapping("/login")
    public ModelAndView login(Customer customer) {

    	ModelAndView mv = new ModelAndView();

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
        		customer.getUserName(),customer.getPassWord()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            mv.addObject("message","账号或密码错误！");
            mv.setViewName("/login.html");
            return mv;
        } catch (AuthorizationException e) {
            e.printStackTrace();
            mv.addObject("message","没有权限!");
            mv.setViewName("/login.html");
            return mv;
        }


		mv.addObject("customerList", customerService.findCustomerList());
		mv.addObject("customer", customerMapper.findByUserName(customer.getUserName()));
		mv.addObject("message","login success!");
		mv.setViewName("/customer/customerList.html");

        return mv;
    }



	@RequestMapping("/toLogin")
	public ModelAndView toLogin(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/login.html");
		return mv;
	}










     //注解验角色和权限
    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }


}
