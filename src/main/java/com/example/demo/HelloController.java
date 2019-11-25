package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.UserEntity;

@Controller
public class HelloController {


	@ResponseBody
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request,@RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
		request.setAttribute("name", name);
		return "hello";
	}


    @GetMapping(value = "/test")
    public ModelAndView test(HttpServletRequest req) {
        // UserEntity userEntity = getCurrentUser(req);
        UserEntity user = new UserEntity();
        user.setLoginName("tom");
        user.setId(234);
        user.setBindType(1);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("/user/show.html");
        return mv;
    }

    @GetMapping(value = "/name")
    public ModelAndView name(HttpServletRequest req,@RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.setViewName("/user/name.html");
		return mv;
    }


}
