package com.danieldai.testdome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TestdomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestdomeApplication.class, args);
	}

}
