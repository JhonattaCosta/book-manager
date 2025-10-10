package dev.jhonatta.BookManager.core.exceptions;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException(String message) {
        super(message);
    }
}
