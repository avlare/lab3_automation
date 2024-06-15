package org.example;

import com.google.common.base.Strings;

public class Book {
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        // this to show guava lib
        this.author = Strings.isNullOrEmpty(author) ? "undefined" : author;
        this.title = Strings.isNullOrEmpty(title) ? "undefined" : title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isValid() {
        return year > 0;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + year;
    }
}