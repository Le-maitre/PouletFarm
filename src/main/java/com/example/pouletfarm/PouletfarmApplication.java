package com.example.pouletfarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "com.example.pouletfarm")
public class PouletfarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PouletfarmApplication.class, args);
	}

}


