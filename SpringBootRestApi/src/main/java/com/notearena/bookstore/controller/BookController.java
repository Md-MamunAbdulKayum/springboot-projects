package com.notearena.bookstore.controller;

import com.notearena.bookstore.exception.BookAlreadyExistsException;
import com.notearena.bookstore.exception.BookNotFoundException;
import com.notearena.bookstore.model.Book;
import com.notearena.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * ------------------------------------------------------|
 * Spring Boot REST API
 * =====================================
 * 2023 NoteArena.com opensource project
 * @Author: Mamun Kayum
 * @Modified:
 * @Version: 1.0
 * Feel free use this implementation
 *-------------------------------------------------------|
 */

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookRepository.findByTitleAndAuthor(book).ifPresent(book1 -> {throw new BookAlreadyExistsException("Book already exists!");});
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        Book updatedBook = bookRepository.update(existingBook.getId(),existingBook);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + id));
        bookRepository.delete(book.getId());
        return ResponseEntity.noContent().build();
    }

}
