package com.example.restemplate;

import com.example.restemplate.itunes.service.ItunesService;
import com.example.restemplate.sampleshawnmendes.service.ShawnMendesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestemplateApplication {

    @Autowired
    ItunesService itunesService;

    @Autowired
    ShawnMendesService shawnMendesService;

    public static void main(String[] args) {
        SpringApplication.run(RestemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
        itunesService.fetchShawnMendesSongs();
        shawnMendesService.testClient();
    }

}
