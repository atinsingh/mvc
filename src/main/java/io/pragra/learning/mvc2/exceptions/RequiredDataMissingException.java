package io.pragra.learning.mvc2.exceptions;

public class RequiredDataMissingException extends RuntimeException {
    public RequiredDataMissingException(String msg) {
        super(msg);
    }
}
