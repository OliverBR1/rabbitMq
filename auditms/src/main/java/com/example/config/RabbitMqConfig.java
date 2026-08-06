package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String AUDIT_QUEUE = "audit_queue";
    public static final String PIX_EFETUADO_EXCHANGE = "pix efetuado";

    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter(){
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(AUDIT_QUEUE);
    }

    @Bean
    public TopicExchange pixEfetuadoExchange(){
        return new TopicExchange(PIX_EFETUADO_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue auditQueue, TopicExchange pixEfetuadoExchange) {
        return BindingBuilder.bind(auditQueue).to(pixEfetuadoExchange).with("*");
    }
}
