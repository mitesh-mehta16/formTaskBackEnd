package com.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringFormTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFormTaskApplication.class, args);
//		WebClientAutoConfiguration webClient = WebClientCustomizer.create("http://localhost:8080");

	}

}
