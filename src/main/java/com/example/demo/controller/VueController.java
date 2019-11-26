package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/vue")
public class VueController {



	@RequestMapping("/vueStart")
	public ModelAndView testdb(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/vueStart.html");
		return mv;
	}

}
