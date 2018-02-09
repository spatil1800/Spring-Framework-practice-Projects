package com.sj.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sj.bean.User;
import com.sj.dao.UserDao;

@Configuration
@EnableWebMvc
@ComponentScan("com.sj")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
	InternalResourceViewResolver resolver =
	new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	resolver.setExposeContextBeansAsAttributes(true);
	return resolver;
	}
	
	 @Autowired
	   private Environment env;// for reading db.properties

	   @Bean
	   public DataSource getDataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(env.getProperty("db.DRIVER"));
	      dataSource.setUrl(env.getProperty("db.URL"));
	      dataSource.setUsername(env.getProperty("db.USER"));
	      dataSource.setPassword(env.getProperty("db.PWD"));
	      return dataSource;
	   }


	   @Bean
	   public LocalSessionFactoryBean getSessionFactory() {
	      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	      factoryBean.setDataSource(getDataSource());//a
	      
	      Properties props=new Properties();
	      props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));//b

	      factoryBean.setHibernateProperties(props);
	      factoryBean.setAnnotatedClasses(User.class);//c
	      return factoryBean;
	   }

	   @Bean
	   public HibernateTemplate getHibernateTemplate() {
		   HibernateTemplate t = new HibernateTemplate();
		   t.setSessionFactory(getSessionFactory().getObject());
		   return t;
	   }

	   @Bean
	   public HibernateTransactionManager getTransactionManager() {
	      HibernateTransactionManager transactionManager = 
	    		  		new HibernateTransactionManager();
	      transactionManager.setSessionFactory(getSessionFactory().getObject());
	      return transactionManager;
	   }

	   @Bean
	   public UserDao getUserDao() {
	      UserDao dao = new UserDao();
	      dao.setTemplate(getHibernateTemplate());
	      return dao;
	   }
	   
	   //MultiPart Support
	   @Bean
	   public MultipartResolver multipartResolver() throws IOException {
	   return new StandardServletMultipartResolver();
	   }
}
