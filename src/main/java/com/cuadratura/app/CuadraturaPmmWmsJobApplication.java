package com.cuadratura.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CuadraturaPmmWmsJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuadraturaPmmWmsJobApplication.class, args);
	}

}
