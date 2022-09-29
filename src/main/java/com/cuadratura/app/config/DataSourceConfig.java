package com.cuadratura.app.config;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder; 

@Configuration 
public class DataSourceConfig   {
	
	@Bean
	@Primary
	@ConfigurationProperties (prefix= "oracle.datasource")
	DataSource dsOne (){
		 return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties (prefix= "mysql.datasource")
	DataSource dsTwo (){
		 return DruidDataSourceBuilder.create().build();
	}	
}
