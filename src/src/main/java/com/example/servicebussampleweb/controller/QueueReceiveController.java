package com.example.servicebussampleweb.controller;

import com.example.servicebussampleweb.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiveController {
    private static final String QUEUE_NAME = "myqueue1";
    private final Logger logger = LoggerFactory.getLogger(QueueReceiveController.class);

    @JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(User user) {
        logger.info("Received messaeg: {}", user.getName());
    }
}
