package com.example.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.example.config.RabbitMqConfig.PF_QUEUE;

@Component
public class PfListener {

    private Logger logger = LoggerFactory.getLogger(PfListener.class);

    @RabbitListener(queues = PF_QUEUE)
    public void listen(Message<PixReq> message){
        logger.info("PF - Message received: {}", message);
    }
}
