package com.practice.bookcatalogservice.models;


public class BookRating {
    private String bookId;
    private int rating;

    public BookRating(){

    }
    public BookRating(String bookId, int rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public String getBookId() {
        return bookId;
    }

    public BookRating setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public BookRating setRating(int rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "BookRating{" +
                "bookId='" + bookId + '\'' +
                ", rating=" + rating +
                '}';
    }
}
