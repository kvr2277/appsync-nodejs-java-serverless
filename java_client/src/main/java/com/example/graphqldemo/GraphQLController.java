package com.example.graphqldemo;


import java.util.Map;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;



@RestController
public class GraphQLController {
  

    @RequestMapping(value = "/graphql", method = RequestMethod.POST)
    public String myGraphql(@RequestBody Map<String, Object> requestBody) throws Exception {

        WebClient.ResponseSpec response = AppSyncClientHelper.getResponseBodySpec(requestBody);

        String bodyString = response.bodyToMono(String.class).block();

        return bodyString;
    }
}
