package com.ifmt.gerenciamentoMudas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GerenciamentoMudasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoMudasApplication.class, args);
	}

}
