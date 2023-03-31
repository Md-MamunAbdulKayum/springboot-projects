package com.notearena.bookstore.exception;

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
public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException() {
        super();
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
