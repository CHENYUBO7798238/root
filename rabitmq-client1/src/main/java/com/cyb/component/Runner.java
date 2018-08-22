package com.cyb.component;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cyb.Application;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
    private final RabbitTemplate rabbitTemplate;

    public Runner( RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        StringBuffer str = new StringBuffer();
        for (String string : args) {
        	str.append(string);
		}
        String string = str.toString();
        System.err.println("生产者:"+string);
		rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", string);
    }

}