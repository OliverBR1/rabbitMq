package com.example.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.AbstractJacksonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.cloud.function.context.config.JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static String PIX_EFETUADO_EXCHANGE = "pix efetuado";

    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter(){
        return new JacksonJsonMessageConverter();
    }

    @Bean
    public TopicExchange pixEfetuadoExchange(){
        return new TopicExchange(PIX_EFETUADO_EXCHANGE);
    }
}
