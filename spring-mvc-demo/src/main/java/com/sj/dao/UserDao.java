package com.sj.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sj.bean.User;
@Transactional
public class UserDao {

HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void addUser(User user) {
		template.save(user);
	}
	public void updateUser(User user) {
		template.saveOrUpdate(user);
	}
	
	public void deleteUser(int id) {
		User user=template.get(User.class,id);
		template.delete(user);
	}
	
	public User getUser(int id) {
		return template.get(User.class,id);
	}
	
	public List<User> getAllUsers(){	
		List<User> users=template.loadAll(User.class);
		return users;
	}
}
