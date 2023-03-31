package com.notearena.bookstore.repository;

import com.notearena.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/*
 * ------------------------------------------------------|
 * Spring boot REST API
 * =====================================
 * 2023 NoteArena.com opensource project
 * @Author: Mamun Kayum
 * @Modified:
 * @Version: 1.0
 * Feel free use this implementation
 *-------------------------------------------------------|
 */

@Repository
public class InMemoryBookRepository implements BookRepository {

    private static final List<Book> books = new ArrayList<>();

    private static final AtomicLong counter = new AtomicLong();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null));
    }

    @Override
    public Optional<Book> findByTitleAndAuthor(Book bookObj) {
        return Optional.ofNullable(books.stream()
                .filter(book -> book.getTitle().equals(bookObj.getTitle()) && book.getAuthor().equals(bookObj.getAuthor()))
                .findFirst()
                .orElse(null));
    }

    @Override
    public void save(Book book) {
        book.setId(counter.incrementAndGet());
        books.add(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Optional<Book> existingBook = findById(id);
        if (existingBook != null) {
            existingBook.get().setTitle(book.getTitle());;
            existingBook.get().setAuthor(book.getAuthor());
        }
        return book;
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}