package org.example.exceptions;

public class ElementIsEmptyException extends RuntimeException {
    public ElementIsEmptyException(String message) {
        super(message);
    }
}
