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

    public BoardCell(int row, int column, GameSymbol symbol) {
        this.row = row;
        this.column = column;
        this.symbol = symbol;
    }

    public BoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public BoardCell(){}
    public GameSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }
}
