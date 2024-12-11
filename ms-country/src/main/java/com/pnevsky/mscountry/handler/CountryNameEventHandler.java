//package com.pnevsky.mscountry.handler;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//@KafkaListener(topics = "country-name-topic")
//public class CountryNameEventHandler {
//
//    private RestTemplate restTemplate;
//
//    public void handle(@Payload ProductCreatedEvent productCreatedEvent,
//                       @Header("messageId") String messageId,
//                       @Header(KafkaHeaders.RECEIVED_KEY), String messageKey){
//
//    }
//}
