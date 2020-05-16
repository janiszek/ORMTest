package com.janiszewski;

import com.janiszewski.entity.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.List;

@Slf4j //lombok
@AllArgsConstructor //lombok
@SpringBootApplication
public class ORMTestApplication implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(ORMTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting ORMTestApplication");

        System.out.println("Adding 2 authors...");
        Author author1 = new Author(null, "Adam", "Mickiewicz", Date.valueOf("1815-01-01"), null);
        //add embedded entity Address
        Address address1 = new Address("Rynek 14", "Wroclaw", "Poland");
        author1.setAddress(address1);
        Author author2 = new Author(null, "Eberhard", "Wolff", Date.valueOf("1975-12-12"), null);
        //add embedded entity Address
        Address address2 = new Address("Hauptstrasse 12", "Hannover", "Germany");
        author2.setAddress(address2);
        authorRepo.save(author1);
        authorRepo.save(author2);

        List<Author> authorList = authorRepo.findAll();
        System.out.println("Show all authors: "+authorList);
        System.out.println("Author with ID=1: "+authorRepo.findById(1L));
        System.out.println("Deleting the first Author...");
        authorRepo.delete(author1);
        System.out.println("All authors after delete:"+ authorRepo.findAll());

        System.out.println("\nAdding 2 books...");
        Book book1 = new Book(null, "Pan Tadeusz", "1234567890", Date.valueOf("1815-04-01"));
        Book book2 = new Book(null, "Continuous Delivery", "0987654321", Date.valueOf("2012-12-12"));
        bookRepo.save(book1);
        bookRepo.save(book2);

        List<Book> bookList = bookRepo.findAll();
        System.out.println("Show all books: "+bookList);
        System.out.println("Book with ID=2: "+bookRepo.findById(2L));
        System.out.println("Deleting the second Book...");
        bookRepo.delete(book2);
        System.out.println("All books after delete:"+ bookRepo.findAll());

    }
}
