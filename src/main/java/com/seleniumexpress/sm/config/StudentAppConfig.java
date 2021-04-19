package com.seleniumexpress.sm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mysql.cj.jdbc.Driver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.seleniumexpress"})
public class StudentAppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// setup datasource
		dataSource.setUsername("root");
		dataSource.setPassword("rootroot");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/seleniumexpress?useSSL=false");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dataSource;		
	}
    @Bean
       public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
    	SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
    	Properties properties = new Properties();
    	properties.put("java.lang.RuntimeException", "runtimeException");
    	resolver.setExceptionMappings(properties);
    	resolver.setDefaultErrorView("genericView");
		return resolver;
       }

}
