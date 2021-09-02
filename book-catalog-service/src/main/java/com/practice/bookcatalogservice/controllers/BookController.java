package com.practice.bookcatalogservice.controllers;

import com.practice.bookcatalogservice.models.BookCatalog;
import com.practice.bookcatalogservice.services.BookCatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/catalogs")
public class BookController {
    private final BookCatalogService bookCatalogService;

    public BookController(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @GetMapping("/")
    public List<BookCatalog> getAll(){
        return bookCatalogService.getAll();
    }

    @GetMapping("/{bookId}")
    public BookCatalog findBy(@PathVariable String bookId) throws NoSuchElementException{
        return bookCatalogService.findBy(bookId)
                .orElseThrow(NoSuchElementException::new);
    }
}
