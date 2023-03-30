package com.notearena.bookstore.repository;

import com.notearena.bookstore.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void update(Long id, Book book);

    void delete(Long id);
}