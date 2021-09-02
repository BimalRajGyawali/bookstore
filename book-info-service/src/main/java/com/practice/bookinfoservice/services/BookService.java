package com.practice.bookinfoservice.services;

import com.practice.bookinfoservice.models.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final List<Book> books;

    public BookService() {
        books = Arrays.asList(
                new Book("1", "Seto Dharti","Amar Neupane"),
                new Book("2","Babu, Aama ra Chhora","BP Koirala"),
                new Book("3","Palpasa Cafe","Narayan Wagle")
        );
    }

    public List<Book> getAll(){
        return books;
    }

    public Optional<Book> findById(String id){
        return
                books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }
}
