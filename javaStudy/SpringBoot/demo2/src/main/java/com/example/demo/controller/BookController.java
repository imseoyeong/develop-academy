package com.example.demo.controller;

import com.example.demo.data.Book;
import com.example.demo.data.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor //bookRepository에게 빈 객체 주입
public class BookController {
    private final BookRepository bookRepository; // 멤버변수 선언

    @GetMapping(value = "/booklist")
    public List<Book> booklist() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/book/{id}")
    public Book book(@PathVariable Integer id) {
        Optional<Book> book = this.bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @PostMapping(value = "/book")
    public Book addBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    @DeleteMapping(value = "/book/{id}")
    public String deleteBook(@PathVariable Integer id) {
        if (this.bookRepository.existsById(id)) {
            this.bookRepository.deleteById(id);
            return "Deleted Book";
        }
        return "Deleted fail";
    }
}
