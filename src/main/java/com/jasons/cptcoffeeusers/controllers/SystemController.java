package com.jasons.cptcoffeeusers.controllers;

import com.jasons.cptcoffeeusers.api.SystemApi;
import com.jasons.cptcoffeeusers.model.SystemPingResponse;
import com.jasons.cptcoffeeusers.model.SystemPingResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.Date;

@RestController
public class SystemController implements SystemApi {

    @Autowired
    RestClient restClient;

    @Override
    public ResponseEntity<SystemPingResponseWrapper> systemPing() {
        Date curr = new Date();
        System.out.println(curr + " | System being called");
        SystemPingResponseWrapper wrapper = new SystemPingResponseWrapper();
        SystemPingResponse response = new SystemPingResponse();

        response.setMessage("System up and running ...");
        wrapper.setData(response);
        wrapper.setError(null);

        callWikiService();

        return ResponseEntity.status(HttpStatus.OK)
                .body(wrapper);
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void callWikiService(){
        restClient.get()
                .uri("/")
                .retrieve()
                .body(SystemPingResponseWrapper.class);
    }
}
