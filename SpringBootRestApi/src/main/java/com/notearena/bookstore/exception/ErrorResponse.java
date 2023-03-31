package com.notearena.bookstore.exception;

import org.springframework.http.HttpStatus;

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
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private long timestamp;

    public ErrorResponse(HttpStatus status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // getters and

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}