package com.cuadratura.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateConfig {
	
	@Bean
	@Primary
	JdbcTemplate jdbctemplateOne(@Qualifier("dsOne") DataSource dsOne) {
		return new JdbcTemplate(dsOne);
	}

	@Bean
	JdbcTemplate jdbctemplateTwo(@Qualifier("dsTwo") DataSource dsTwo) {
		return new JdbcTemplate(dsTwo);
	}
}
