package com.madagascar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.madagascar.dao")
public class ElectricApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricApplication.class, args);
	}
}
