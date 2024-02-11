package com.example.sem9HWgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sem9HwGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(Sem9HwGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator customRoutLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route("Microservice1", r->r.path("/products/**")
						.uri("http://localhost:8081/")).build();
	}

}
