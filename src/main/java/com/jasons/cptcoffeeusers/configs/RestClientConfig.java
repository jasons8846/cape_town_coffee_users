package com.jasons.cptcoffeeusers.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://cape-town-coffee-1-8ao2.onrender.com")
                .build();
    }
}
