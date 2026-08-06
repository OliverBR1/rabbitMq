package com.example.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.example.config.RabbitMqConfig.AUDIT_QUEUE;

@Component
public class AuditListener {

    private Logger logger = LoggerFactory.getLogger(AuditListener.class);

    @RabbitListener(queues = AUDIT_QUEUE)
    public void listen(Message<PixReq> message){
        logger.info("AUDIT - Message received: {}", message);
    }
}
