package com.epc.product.config;



import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.epc.product.dao.LocationDAO;
import com.epc.product.dao.ProductLoaderDAO;

@Configuration
/*@EnableJpaRepositories(basePackages = {
        " com.epc.product.dao"})*/
public class DatabaseConfig {
	@Bean
	@Qualifier("dataSource")
	public DataSource dataSource(Environment env) throws SQLException {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		//ds.setUrl("jdbc:mysql://epc.camshkvripre.us-east-1.rds.amazonaws.com:3306");
		ds.setUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		ds.setSchema(env.getProperty("spring.datasource.name"));
		return ds;
	}
	
	@Bean
	@Qualifier("jdbcTemplete")
	public JdbcTemplate jdbcTemplete(DataSource dataSource){
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		jdbcTemplate.setFetchSize(100);
		return jdbcTemplate;
	}
	@Bean
	@Qualifier("productLoaderDAO")
	public ProductLoaderDAO productLoaderDAO(DataSource ds) {
		ProductLoaderDAO productLoaderDAO = new ProductLoaderDAO();
		return productLoaderDAO;
	}
	@Bean
	@Qualifier("locationDAO")
	public LocationDAO locationDAO(DataSource ds) {
		LocationDAO locationDAO = new LocationDAO();
		return locationDAO;
	}
	
	
	
}
