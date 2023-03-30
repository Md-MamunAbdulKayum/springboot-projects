package com.notearena.bookstore.repository;

import com.notearena.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private static final List<Book> books = new ArrayList<>();

    private static final AtomicLong counter = new AtomicLong();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book findById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Book book) {
        book.setId(counter.incrementAndGet());
        books.add(book);
    }

    @Override
    public void update(Long id, Book book) {
        Book existingBook = findById(id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
        }
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}