package com.practice.bookcatalogservice.services;

import com.practice.bookcatalogservice.models.Book;
import com.practice.bookcatalogservice.models.BookCatalog;
import com.practice.bookcatalogservice.models.BookRating;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookCatalogService {
    private final RestTemplate restTemplate;

    public BookCatalogService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<BookCatalog> findBy(String bookId) {
        String BOOK_URL = "http://localhost:8081/books/";
        String RATING_URL = "http://localhost:8082/ratings/";
        try {
            Book book = restTemplate.getForObject(BOOK_URL +""+ bookId, Book.class);
            BookRating rating = restTemplate.getForObject(RATING_URL +""+ bookId, BookRating.class);

            if (book != null && rating != null) {
                return Optional.of(BookCatalog.from(book, rating));
            }

        } catch (Exception e) {
            System.out.println("Something went wrong....");
        }

        return Optional.empty();
    }

}
