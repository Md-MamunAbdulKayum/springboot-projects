package com.notearena.bookstore.repository;

import com.notearena.bookstore.model.Book;

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

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByTitleAndAuthor(Book bookObj);

    void save(Book book);

    Book update(Long id, Book book);

    void delete(Long id);
}