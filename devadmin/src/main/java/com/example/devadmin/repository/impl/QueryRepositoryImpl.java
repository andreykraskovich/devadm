package com.example.devadmin.repository.impl;

import com.example.devadmin.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueryRepositoryImpl implements QueryRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public String query(String queryString) {
        jdbcTemplate.update(queryString);
        return "yes";
    }
}
