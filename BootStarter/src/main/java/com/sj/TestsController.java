package com.sj;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class TestsController {
	
	
		@RequestMapping("/hello/{name}")
		public String sayHello(@PathVariable String name) {
			return "index";
		}
		
		@RequestMapping("/hello")
		public String sayHello1() {
			return "<h1>Hello Hello</h1>";
		}
}
