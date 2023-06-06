package com.example.restemplate.itunes.service;

import com.example.restemplate.itunes.proxy.ItunesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
class ItunesMapper {

    ItunesResponse mapJsonToItunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ItunesResponse.class);
    }
}
