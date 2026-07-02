package com.example.interview.client;

import com.example.interview.client.dto.DummyProductListDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DummyJsonProductClient {

    private final RestTemplate restTemplate;

    public DummyJsonProductClient() {
        this.restTemplate = new RestTemplate();
    }

    public DummyProductListDto searchProducts(String query) {
        String url = "https://dummyjson.com/products/search?q=" + query;
        return restTemplate.getForObject(url, DummyProductListDto.class);
    }
}
