package com.example.restemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ShawnMendesProxy {

    @Autowired
    RestTemplate restTemplate;

    public String makeShawnMendesRequest(String term, Integer limit) {
        // GET https://itunes.apple.com/search?term=shawnmendes&limit=1
        String uri = "https://itunes.apple.com/search?term=" + term + "&limit=" + limit;
        ResponseEntity<String> exchange = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        return exchange.getBody();
    }

}
