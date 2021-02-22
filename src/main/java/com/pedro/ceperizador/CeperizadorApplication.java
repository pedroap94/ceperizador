package com.pedro.ceperizador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CeperizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeperizadorApplication.class, args);
	}

}
