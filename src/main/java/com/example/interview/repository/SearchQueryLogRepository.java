package com.example.interview.repository;

import com.example.interview.entity.SearchQueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchQueryLogRepository extends JpaRepository<SearchQueryLog, Long> {
}
