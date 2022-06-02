package com.learning.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.learning.jdbc")
@PropertySource("classpath:application.properties")
public class MyApplicationConfig {

	@Value("${jdbc.mysql.driverName}")
	private String driverName;
	@Value("${jdbc.mysql.url}")
	private String url;
	@Value("${jdbc.mysql.username}")
	private String username = "root";
	@Value("${jdbc.mysql.password}")
	private String password ;

	@Bean
	public DataSource datSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

}
