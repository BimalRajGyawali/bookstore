package com.practice.bookratingservice.controllers;

import com.practice.bookratingservice.models.BookRating;
import com.practice.bookratingservice.services.BookRatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ratings")
public class BookRatingController {

    private final BookRatingService bookRatingService;

    public BookRatingController(BookRatingService bookRatingService) {
        this.bookRatingService = bookRatingService;
    }

    @GetMapping("/")
    public List<BookRating> getAll(){
        return bookRatingService.getAll();
    }

    @GetMapping("/{id}")
    public BookRating getRatingOf(@PathVariable String id) throws NoSuchElementException{
        return bookRatingService.getRatingOf(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
