package com.practice.bookinfoservice.controllers;

import com.practice.bookinfoservice.models.Book;
import com.practice.bookinfoservice.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String id) throws NoSuchElementException{
       return bookService.findById(id)
               .orElseThrow(NoSuchElementException::new);
    }
}
