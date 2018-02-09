package com.sj.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sj.bean.User;
import com.sj.dao.UserDao;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
	};
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String doRegister(@RequestPart MultipartFile profilePicture,@Valid User user,Errors error,RedirectAttributes model) throws IllegalStateException, IOException {
		System.out.println(user);
		if(error.hasErrors())
			return "register";
		userDao.addUser(user);
		if(!profilePicture.isEmpty())
		profilePicture.transferTo(
				new File(profilePicture.getOriginalFilename()));
		User user1=userDao.getUser(2);
		model.addAttribute("user1",user1.getId());
		model.addFlashAttribute("user",user1);
		return "redirect: /spring-mvc-demo/home/{user1}";
	}
	
	@RequestMapping("home/{user}")
	public String homepage(@PathVariable int user,Model model) {
		if (!model.containsAttribute("spitter")) {
			model.addAttribute("user",userDao.getUser(user));
			}
		return "success";
	}
}
