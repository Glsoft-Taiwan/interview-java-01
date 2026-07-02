package com.example.interview.service;

import com.example.interview.client.DummyJsonProductClient;
import com.example.interview.dto.SearchAndLogResponse;
import com.example.interview.repository.SearchQueryLogRepository;

public class ProductService {

    private final DummyJsonProductClient productClient;
    private final SearchQueryLogRepository queryLogRepository;

    public ProductService(DummyJsonProductClient productClient, SearchQueryLogRepository queryLogRepository) {
        this.productClient = productClient;
        this.queryLogRepository = queryLogRepository;
    }

    public SearchAndLogResponse searchFilterAndLog(String query, Double minPrice, String sortBy) {
        // TODO: Implement the business logic:
        // 1. Fetch raw product data using productClient.
        // 2. Filter products: exclude products with price < minPrice when minPrice is provided.
        //    Throw NoProductsFoundException if no products match or exist.
        // 3. Compute stats: averagePrice and maxDiscount on the filtered products.
        // 4. Sort the filtered products in descending order based on sortBy: price, rating, or discount.
        // 5. Save search metadata via queryLogRepository and get the generated logId.
        // 6. Map the sorted list and statistics to SearchAndLogResponse DTO and return it.

        return null; // Replace with your implementation
    }
}
