package com.console_project.exception;

/**
 * Исключение, которое кидается, когда заканчиваются незанятые значения id.
 */

public class TooMuchElementsException extends RuntimeException {
    public TooMuchElementsException(){
        super("Too much elements in collection");
    }
}
