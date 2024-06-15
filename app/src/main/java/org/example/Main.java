package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        String filePath = "app\\src\\main\\resources\\list_books.txt";
        library.loadBooksFromFile(filePath);
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}