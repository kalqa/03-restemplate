package com.example.restemplate.sampleshawnmendes.service;

import com.example.restemplate.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import com.example.restemplate.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShawnMendesService {

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerClient;

    @Autowired
    ShawnMendesServiceMapper shawnMendesServiceMapper;

    public void testClient() throws JsonProcessingException {
        String postJsonSampleShawnMendesServer = sampleShawnMendesServerClient.makePostRequest();
        String getJsonSampleShawnMendesServer = sampleShawnMendesServerClient.makeGetRequest();
        if (getJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }
        sampleShawnMendesServerClient.makeDeleteRequest("0");
        String getJsonSampleShawnMendesServer2 = sampleShawnMendesServerClient.makeGetRequest();
        if (postJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(postJsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }

        if (getJsonSampleShawnMendesServer2 != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer2);
            System.out.println(sampleShawnMendesResponse);
        }
    }

}
