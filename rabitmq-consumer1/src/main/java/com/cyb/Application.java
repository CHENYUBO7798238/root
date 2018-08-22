package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static final String topicExchangeName = "spring-boot-exchange";

    public static final String queueName = "spring-boot";

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}
}
