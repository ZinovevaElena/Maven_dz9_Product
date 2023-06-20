package ru.netology.maven.product;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(String m) {
        super(m);
    }
}
