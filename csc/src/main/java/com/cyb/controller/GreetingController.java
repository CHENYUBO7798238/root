package com.cyb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.cyb.entity.Greeting;
import com.cyb.entity.Message;

@RestController
public class GreetingController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public void greeting(Message message) throws Exception {
		Greeting payload = new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
		simpMessagingTemplate.convertAndSend("/topic/greetings",payload);
       // Thread.sleep(1000); // simulated delay
      //  return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
	
  @MessageMapping("/hello2")
  public void greeting2(Message message) throws Exception {
	  simpMessagingTemplate.convertAndSendToUser("1", "/message", new Greeting("Hello2, " + HtmlUtils.htmlEscape(message.getName()) + "!"));
  }
}
