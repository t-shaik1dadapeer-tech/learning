package com.example.notificationservice.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalApiService {
    @Autowired
    private RestTemplate restTemplate;
    public String callExternalApi(){
        String url="http://jsonplaceholder.typicode.com/posts/1";
        try{
            return restTemplate.getForObject(url,String.class);
        } catch (Exception e){
            System.out.println("Error calling externaql API: " + e.getMessage());
            return "Fallback response";
        }
    }
}
