package com.river.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * @author ttgiang
 *	Create Binding for each Queues. We do not need to specify a binding key.
 */
@Configuration
public class RabbitMQFanoutConfig {

	@Bean
	Queue marketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	Queue financeQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	Queue adminQueue() {
		return new Queue("adminQueue", false);
	}

	@Bean
	FanoutExchange exchange() {
		return new FanoutExchange("fanout-exchange");
	}

	@Bean
	Binding marketingBinding(Queue marketingQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(marketingQueue).to(exchange);
	}

	@Bean
	Binding financeBinding(Queue financeQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(financeQueue).to(exchange);
	}

	@Bean
	Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
		return BindingBuilder.bind(adminQueue).to(exchange);
	}
}
