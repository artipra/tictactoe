package com.backend.tictactoe2.exception;

public class InvalidSymbolException extends RuntimeException {

    public InvalidSymbolException(){
        System.out.println("Invalid symbol select (O or X)");
    }
}
