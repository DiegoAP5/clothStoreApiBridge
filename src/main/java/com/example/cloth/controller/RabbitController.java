package com.example.cloth.controller;

import com.example.cloth.configuration.Rabbit;
import com.example.cloth.dtos.CreateEvent;
import com.example.cloth.dtos.UpdateRefundRequest;
import com.example.cloth.dtos.UpdateSendRequest;
import com.example.cloth.service.EventSend;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@CrossOrigin
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private EventSend eventSend;

    @PostMapping("/delivered")
    public void sendEvent(@RequestBody UpdateSendRequest request){
        template.convertAndSend(Rabbit.EXCHANGE,"ms.event.order.delivered",request);
    }

    @PostMapping("/refund")
    public void sendEventRefund(@RequestBody UpdateRefundRequest request){
        template.convertAndSend(Rabbit.EXCHANGE,"ms.event.notification",request);
    }

    @PostMapping("/order")
    public void sendEventOrder(@RequestBody UpdateSendRequest request){
        template.convertAndSend(Rabbit.EXCHANGE,"ms.event.order.inProcess",request);
    }
}
