package com.sj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public String add(@RequestParam("t1") int num1,@RequestParam("t2") int num2,Model model) {
		int k=(num1+num2);
		model.addAttribute("result", k);
		return "result";
	}
}
