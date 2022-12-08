package com.springboot.hospitalboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class HospitalBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalBoardApplication.class, args);
	}

}
