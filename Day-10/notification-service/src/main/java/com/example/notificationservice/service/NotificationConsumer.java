package com.example.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private ExternalApiService externalApiService;

    @KafkaListener(topics = "user-created", groupId = "notification-group")
    public void consume(String message) {
        try {
            System.out.println("Processing: "+ message);

            String response = externalApiService.callExternalApi();
            System.out.println("Notification sent: " + message);
        } catch (Exception e){
            System.out.println("Error processing message:" + message);
        }
    }
}