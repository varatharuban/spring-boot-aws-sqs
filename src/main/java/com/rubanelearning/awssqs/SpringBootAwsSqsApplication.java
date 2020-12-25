package com.rubanelearning.awssqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = { ContextStackAutoConfiguration.class })
@RestController
public class SpringBootAwsSqsApplication {

	Logger logger = LoggerFactory.getLogger(SpringBootAwsSqsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsSqsApplication.class, args);
	}

	@SqsListener("rbn-queue")
	public void loadMessageFromSQS(String message) {
		logger.info("Spring boot system reading message from SQS Queue {}", message);
	}

}
