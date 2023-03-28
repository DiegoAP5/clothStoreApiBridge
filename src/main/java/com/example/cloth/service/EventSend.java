package com.example.cloth.service;

import com.example.cloth.dtos.CreateEvent;
import com.example.cloth.dtos.UpdateSendRequest;
import com.example.cloth.publisher.Publisher;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventSend{

    @Autowired
    private Publisher publisher;

    public void send(String queue, UpdateSendRequest request) {

    }
}
