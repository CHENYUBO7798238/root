package com.cyb.component;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import com.cyb.Application;
import com.rabbitmq.client.Channel;

@Component
@RabbitListener(queues=Application.queueName)
public class Receiver implements ChannelAwareMessageListener{

	static int count;
	
	@RabbitHandler(isDefault=false)
	public void onMessage(String a) throws Exception {
		System.err.println("消费者:"+a);
	}

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		if(count<=100) {
			System.err.println(new String(message.getBody()));
			System.err.println(message.getMessageProperties().getDeliveryTag());
			System.err.println("count:" + count++);
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
		}else {
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}
	}

}