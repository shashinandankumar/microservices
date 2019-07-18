package com.example.rmqueue.queueproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.rmqueue.*")
public class QueueproducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueproducerApplication.class, args);
	}

}
