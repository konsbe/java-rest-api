package com.vone.javarest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.core.env.Environment;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.queue.name}")
    private String queueName;
    @Value("${rabbitmq.topic.exchange.name}")
    private String topicExchangeName;
    @Value("${rabbitmq.queue.route.key}")
    private String routingKey;
    @Autowired
    private Environment environment;

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    // @Bean
    // public MessageConverter converter() {
    //     ObjectMapper mapper = new ObjectMapper();
    //     // Customize the mapper as needed, e.g., enable features, set serialization
    //     // views
    //     return new Jackson2JsonMessageConverter(mapper);
    // }
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("localhost");  // or your RabbitMQ server address
        connectionFactory.setUsername(environment.getProperty("sci_tech_city_rabbitmq.username").toString());
        connectionFactory.setPassword(environment.getProperty("sci_tech_city_rabbitmq.password").toString());
        connectionFactory.setChannelCheckoutTimeout(10000); // Extended timeout
        connectionFactory.setChannelCacheSize(25); // Adjust based on concurrency needs
        return connectionFactory;
    }
}
