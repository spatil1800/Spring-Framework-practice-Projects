package com.sj.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sj.bean.User;
import com.sj.dao.UserDao;

@RestController
public class UserController {
	List<User> users=new ArrayList<User>(Arrays.asList(
			new User(1,"Suraj","spatil@gmail.com",8237621620L),
			new User(2,"Sj","sj@gmail.com",82376220L),
			new User(3,"Patil","patil@gmail.com",81620L),
			new User(4,"sjp","sjp@gmail.com",82621620L)
			));
	@Autowired
	UserDao userDao;
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable int id){
		return userDao.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user){
		userDao.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users")
	public void updateUser(@RequestBody User user){
		userDao.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable int id){
		userDao.deleteUser(id);
	}
	
}
