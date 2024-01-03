package com.example.pouletfarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.pouletfarm")
public class PouletfarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PouletfarmApplication.class, args);
	}

}


