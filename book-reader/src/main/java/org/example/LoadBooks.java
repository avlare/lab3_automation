package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadBooks {
    private List<Book> books;

    public LoadBooks() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book.isValid()) {
            books.add(book);
        } else {
            System.out.println("Year must be greater than 0: " + book);
        }
    }

    public void loadBooksFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length == 3) {
                    String author = bookData[0].trim();
                    String title = bookData[1].trim();
                    int year = Integer.parseInt(bookData[2].trim());
                    addBook(new Book(author, title, year));
                } else {
                    // just to add some more methods
                    System.out.println("Cannot add book with no year: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}