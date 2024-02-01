package com.app.hospital.main.exception;

/**
 * Exception class for validating objects
 */
public class InvalidObjectException extends RuntimeException {

    /**
     * Constrecteur
     *
     * @param nameField missing field in object
     */
    public InvalidObjectException(final String nameField) {
        super(nameField);
    }
}
