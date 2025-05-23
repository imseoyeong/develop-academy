package com.example.madang_project.data.dao;

import com.example.madang_project.data.repository.BookEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDAO {
    private final BookEntityRepository bookEntityRepository;
}
