package com.example.interview.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DummyProductListDto(
    List<DummyProductDto> products
) {}
