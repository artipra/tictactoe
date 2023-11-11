package com.backend.tictactoe.models;

public class BoardCell {
    private int row;
    private int column;
    private GameSymbol symbol;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public GameSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }
}
