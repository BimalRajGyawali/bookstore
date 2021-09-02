package com.practice.bookcatalogservice.models;

public class BookCatalog {
    private String id;
    private String name;
    private String author;
    private int rating;

    public BookCatalog() {
    }

    public BookCatalog(String id, String name, String author, int rating) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.rating = rating;
    }

    public static BookCatalog from(Book book, BookRating rating){
        return new BookCatalog(book.getId(), book.getName(), book.getAuthor(), rating.getRating());
    }

    public String getId() {
        return id;
    }

    public BookCatalog setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookCatalog setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookCatalog setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public BookCatalog setRating(int rating) {
        this.rating = rating;
        return this;
    }
}
