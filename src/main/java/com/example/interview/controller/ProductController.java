package com.example.interview.controller;

import com.example.interview.dto.SearchAndLogResponse;
import com.example.interview.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // TODO: Expose GET HTTP endpoint "/search-and-log"
    // Parameters:
    // - "q" (String, required)
    // - "minPrice" (Double, optional)
    // - "sortBy" (String, optional, default: "price")
    // Should call productService.searchFilterAndLog(...) and return ResponseEntity.ok(...)
    public ResponseEntity<SearchAndLogResponse> searchAndLog() {
        return null; // Replace with your implementation
    }
}
