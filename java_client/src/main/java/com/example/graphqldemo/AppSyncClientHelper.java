package com.example.graphqldemo;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class AppSyncClientHelper {

    static String apiUrl = "http://localhost:62222";
    static String apiKey = "SOME_KEY";
    static String API_KEY_HEADER = "x-api-key";

    public static WebClient.ResponseSpec getResponseBodySpec(Map<String, Object> requestBody) {

        System.out.println("****  requestBody  "+requestBody.toString());
        return WebClient
                .builder()
                .baseUrl(apiUrl)
                .defaultHeader(API_KEY_HEADER, apiKey)
                .defaultHeader("Content-Type", "application/json")
                .build()
                .method(HttpMethod.POST)
                .uri("/graphql")
                .body(BodyInserters.fromValue(requestBody))
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .acceptCharset(StandardCharsets.UTF_8)
                .retrieve();
    }

}
