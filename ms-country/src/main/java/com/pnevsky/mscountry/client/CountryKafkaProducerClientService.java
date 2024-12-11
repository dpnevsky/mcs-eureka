package com.pnevsky.mscountry.client;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
public class CountryKafkaProducerClientService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendCountryName(String topic, String key, String message) throws ExecutionException, InterruptedException {
        kafkaTemplate.send(topic, key, message);
    }

}
