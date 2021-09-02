package com.practice.bookratingservice.services;

import com.practice.bookratingservice.models.BookRating;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookRatingService {

    private List<BookRating> bookRatings;

    public BookRatingService(){
        bookRatings = Arrays.asList(
            new BookRating("1", 3),
            new BookRating("2", 4),
            new BookRating("3", 5)
        );
    }

    public List<BookRating> getAll(){
        return bookRatings;
    }

    public Optional<BookRating> getRatingOf(String bookId){
        return bookRatings.stream()
                .filter(bookRating -> bookRating.getBookId().equals(bookId))
                .findFirst();
    }
}
