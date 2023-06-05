package com.example.restemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestemplateApplication {

    @Autowired
    ItunesProxy shawnMendesClient;

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerProxy;

    public static void main(String[] args) {
        SpringApplication.run(RestemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
        String json = shawnMendesClient.makeRequest("shawnmendes", 3);
        if (json != null) {
            ShawnMendesResponse shawnMendesResponse = mapJsonToShawnMendesResponse(json);
            System.out.println(shawnMendesResponse);
        }

        String jsonSampleShawnMendesServer = sampleShawnMendesServerProxy.makeRequest();
        if (jsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = mapJsonToSampleShawnMendesResponse(jsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }
    }

    private ShawnMendesResponse mapJsonToShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShawnMendesResponse.class);
    }

    private SampleServerShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }
}
