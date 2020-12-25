package com.rubanelearning.awssqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Value("${cloud.aws.end-point.uri}")
	private String endpoint;
	
	@Autowired
	QueueMessagingTemplate queueMessagingTemplate;
	
	@GetMapping("/send/{message}")
	public void sendMessageToQueue(@PathVariable String message) {
		queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
	}
}
