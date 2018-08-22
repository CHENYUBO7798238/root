package com.cyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {
	public static final String topicExchangeName = "spring-boot-exchange";

    public static final String queueName = "spring-boot";

    @Bean
    Queue queue() {
        Queue queue = new Queue(queueName, false);
		return queue;
    }

    @Bean
    TopicExchange exchange() {
        TopicExchange topicExchange = new TopicExchange(topicExchangeName);
		return topicExchange;
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(Application.class, args);
	}
}
