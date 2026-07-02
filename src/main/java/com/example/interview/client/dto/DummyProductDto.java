package com.example.interview.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DummyProductDto(
    Long id,
    String title,
    double price,
    double rating,
    double discountPercentage
) {}
