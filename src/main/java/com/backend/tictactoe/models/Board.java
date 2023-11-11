package com.backend.tictactoe.models;

import java.util.Collections;
import java.util.List;

public class Board {
    private int size;
    private List<List<BoardCell>> cells;

    private GameSymbol symbol;

    public Board(int size) {
        this.size = size;
        this.cells = initialiseCells(size);
    }

    private List<List<BoardCell>> initialiseCells(int size) {
        List<BoardCell> firstRow = Collections.nCopies(size,new BoardCell());
        return Collections.nCopies(size,firstRow);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<BoardCell>> getCells() {
        return cells;
    }

    public void setCells(List<List<BoardCell>> cells) {
        this.cells = cells;
    }

    public GameSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(GameSymbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty(int row, int col) {
        return cells.get(row).get(col) != null;

    }

    public void update(BoardCell move) {
        cells.get(move.getRow()).get(move.getColumn()).setSymbol(move.getSymbol());
    }
}
