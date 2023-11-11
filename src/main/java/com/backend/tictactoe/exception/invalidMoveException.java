package com.backend.tictactoe.exception;

public class invalidMoveException extends RuntimeException {
    public invalidMoveException(int row, int col) {
        super("Invalid Move "+row +" " +col);
    }
}
