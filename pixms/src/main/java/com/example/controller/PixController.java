package com.example.controller;

import com.example.controller.dto.PixReq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.config.RabbitMqConfig.PIX_EFETUADO_EXCHANGE;

@RestController
@RequestMapping("/pix")
public class PixController {

    private final RabbitTemplate rabbitTemplate;

    public PixController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> makePix(@RequestBody PixReq req){

        rabbitTemplate.convertAndSend(PIX_EFETUADO_EXCHANGE, req.channel(), req);

        return ResponseEntity.accepted().build();
    }
}
