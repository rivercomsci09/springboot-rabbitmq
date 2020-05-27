package com.river.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.river.model.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${river.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
	}
}
