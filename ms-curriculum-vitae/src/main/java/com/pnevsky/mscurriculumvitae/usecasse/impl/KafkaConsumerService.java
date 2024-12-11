package com.pnevsky.mscurriculumvitae.usecasse.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "country-name-topic")
    public void consumeMessage(String message) {
        System.out.println("Received country name: " + message);
    }
}
