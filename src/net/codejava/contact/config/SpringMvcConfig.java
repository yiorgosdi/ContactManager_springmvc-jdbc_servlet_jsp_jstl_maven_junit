package net.codejava.contact.config;


import javax.sql.DataSource; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.codejava.contact.dao.ContactDAO;
import net.codejava.contact.dao.ContactDAOImpl;

@Configuration 
@EnableWebMvc 
@ComponentScan(basePackages = "net.codejava.contact")
public class SpringMvcConfig implements WebMvcConfigurer {
	
	@Bean 
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource(); 
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/contactdb");
		ds.setUsername("root");
		ds.setPassword("");
		
		return ds; 
	}
	
	@Bean 
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;  
	}

	@Bean 
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());  
		
	}
	
	
}