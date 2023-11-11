package com.backend.tictactoe.exception;

public class InvalidPlayerException extends RuntimeException{
    public InvalidPlayerException() {
        super("Invalid List of Players");
    }
}
