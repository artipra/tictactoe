package com.backend.tictactoe2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCell {

    private int row;
    private int col;
    private Symbol symbol;

    public BoardCell(int row, int col){
        this.row = row;
        this.col = col;
    }

    public BoardCell(){}
    public BoardCell(int row, int col, Symbol symbol){
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }
}
