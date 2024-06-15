package org.example;

public class Main {
    public static void main(String[] args) {
        LoadBooks loadBooks = new LoadBooks();
        String filePath = "app/src/main/resources/list_books.txt";
        loadBooks.loadBooksFromFile(filePath);
        for (Book book : loadBooks.getBooks()) {
            System.out.println(book);
        }
    }
}