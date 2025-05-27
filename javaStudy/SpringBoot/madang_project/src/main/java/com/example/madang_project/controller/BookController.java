package com.example.madang_project.controller;

import com.example.madang_project.data.dto.BookDTO;
import com.example.madang_project.data.entity.BookEntity;
import com.example.madang_project.data.entity.OrderEntity;
import com.example.madang_project.data.repository.BookEntityRepository;
import com.example.madang_project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping(value = "/bookinfo/{id}")
    public ResponseEntity<BookDTO> getBookInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getBookInfo(id));
    }

//    @GetMapping(value = "/booklist")
//    public List<BookEntity> bookList() {
//        return bookEntityRepository.findAll();
//    }
//
//    @GetMapping(value = "/book/{id}")
//    public List<OrderEntity> bookList(@PathVariable Integer id) {
//        BookEntity book = bookEntityRepository.findById(id).orElse(null);
//        List<OrderEntity> list = book.getOrders();
//        return list;
//    }
}
