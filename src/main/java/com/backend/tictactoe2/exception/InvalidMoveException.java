package com.backend.tictactoe2.exception;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int row, int col) {
        System.out.println("This move is invalid. Please select correct place");
    }
}
