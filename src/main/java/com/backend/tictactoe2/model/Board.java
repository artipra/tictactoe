package com.backend.tictactoe2.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Board {
    List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int rows, int cols){
        List<BoardCell>  columnsCells = Collections.nCopies(cols,new BoardCell());
        System.out.println(columnsCells);
        List<List<BoardCell>> rowCells = Collections.nCopies(rows, columnsCells);
        this.cells = rowCells;
    }

    public boolean isEmpty(int row, int col){
        return getBoardCell(row,col).getSymbol() == null;
    }
    public void updateBoard(BoardCell move){
        cells.get(move.getRow()).get(move.getCol()).setSymbol(move.getSymbol());
    }


    private BoardCell getBoardCell(int row, int col){
        return cells.get(row).get(col);
    }

    public List<BoardCell> getEmptyCells(){
        return cells.stream().flatMap(List::stream).filter(c -> c.getSymbol() == null).toList();

    }
    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                Symbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }
}
