package com.cuadratura.app.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan({"com.cuadratura.app.service","com.cuadratura.app.controller"})

@EnableJpaRepositories(entityManagerFactoryRef = "adminEntityManagerFactory", transactionManagerRef = "adminTransactionManager", 
basePackages = { "com.cuadratura.app.oracle.repository"  })
public class OracleConfig {

	@Autowired
	private Environment env;
	
	@Bean(name = "adminDataSource")
	public DataSource adminDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("oracle.datasource.url"));
		dataSource.setUsername(env.getProperty("oracle.datasource.username"));
		dataSource.setPassword(env.getProperty("oracle.datasource.password"));
		dataSource.setDriverClassName(env.getProperty("oracle.datasource.driver-class-name"));
		
		return dataSource;
	}
	

	@Primary
	@Bean(name = "adminEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(adminDatasource());
		//em.setPackagesToScan("com.cuadratura.app.oracle.entity.*");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setPackagesToScan(new String[]{"com.cuadratura.app.oracle.entity", "com.cuadratura.app.oracle.entity.pk"});
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setPersistenceUnitName("jpa_oracle");
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("oracle.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show-sql", env.getProperty("oracle.jpa.show-sql"));
		properties.put("hibernate.dialect", env.getProperty("oracle.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
		
	}
	
	@Primary
	@Bean(name = "adminTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
