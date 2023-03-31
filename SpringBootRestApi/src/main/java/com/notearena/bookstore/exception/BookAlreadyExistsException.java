package com.notearena.bookstore.exception;

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
public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException() {
        super();
    }

    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
