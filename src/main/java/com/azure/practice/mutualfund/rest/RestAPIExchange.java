package com.azure.practice.mutualfund.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Component
public class RestAPIExchange {
    private static final Logger logger = LoggerFactory.getLogger(RestAPIExchange.class);

    public Map<String, Object> postExchange(String url, String payload) throws Exception {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate2 = new RestTemplate();
            String response = restTemplate2.exchange(
                    url, HttpMethod.POST, new HttpEntity<>(payload, headers), String.class).getBody();
            return new Gson().fromJson(response, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            logger.error("Couldn't fetch data with url = {}, errorMessage={}", url, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public Map<String, Object> getExchange(String id) throws Exception {
        String url = "https://api.mfapi.in/mf/" + id;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate2 = new RestTemplate();
            ResponseEntity<String> response = restTemplate2.getForEntity(
                    url, String.class);
            return new Gson().fromJson(response.getBody(), new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            logger.error("Couldn't fetch data with url = {}, errorMessage={}", url, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
