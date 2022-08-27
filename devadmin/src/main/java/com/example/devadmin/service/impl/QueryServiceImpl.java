package com.example.devadmin.service.impl;

import com.example.devadmin.repository.impl.QueryRepositoryImpl;
import com.example.devadmin.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {

    private final QueryRepositoryImpl queryRepository;

    @Override
    public String query(String query) {
        return queryRepository.query(query);
    }
}
