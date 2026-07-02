package com.example.interview.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_query_log")
public class SearchQueryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "query_text", nullable = false)
    private String queryText;

    @Column(name = "min_price_filter")
    private Double minPriceFilter;

    @Column(name = "matched_count", nullable = false)
    private Integer matchedCount;

    @Column(name = "searched_at", nullable = false)
    private LocalDateTime searchedAt;

    public SearchQueryLog() {}

    public SearchQueryLog(String queryText, Double minPriceFilter, Integer matchedCount, LocalDateTime searchedAt) {
        this.queryText = queryText;
        this.minPriceFilter = minPriceFilter;
        this.matchedCount = matchedCount;
        this.searchedAt = searchedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQueryText() { return queryText; }
    public void setQueryText(String queryText) { this.queryText = queryText; }

    public Double getMinPriceFilter() { return minPriceFilter; }
    public void setMinPriceFilter(Double minPriceFilter) { this.minPriceFilter = minPriceFilter; }

    public Integer getMatchedCount() { return matchedCount; }
    public void setMatchedCount(Integer matchedCount) { this.matchedCount = matchedCount; }

    public LocalDateTime getSearchedAt() { return searchedAt; }
    public void setSearchedAt(LocalDateTime searchedAt) { this.searchedAt = searchedAt; }
}
