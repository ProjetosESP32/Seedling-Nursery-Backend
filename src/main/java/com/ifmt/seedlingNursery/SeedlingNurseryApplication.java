package com.ifmt.seedlingNursery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class SeedlingNurseryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeedlingNurseryApplication.class, args);
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
	}
}
