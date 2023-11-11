package com.backend.tictactoe.exception;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException(String s) {
        super(s);
    }
}
