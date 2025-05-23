package com.example.madang_project.data.dao;

import com.example.madang_project.data.repository.OrderEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderEntityRepository orderEntityRepository;
}
