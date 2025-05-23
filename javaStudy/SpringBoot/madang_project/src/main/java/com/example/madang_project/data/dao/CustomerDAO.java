package com.example.madang_project.data.dao;

import com.example.madang_project.data.repository.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDAO {
    private final CustomerEntityRepository customerEntityRepository;
}
