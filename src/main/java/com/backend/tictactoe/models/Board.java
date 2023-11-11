package com.backend.tictactoe.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Getter
public class Board {

    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initialiseCells(size);
    }

    private List<List<BoardCell>> initialiseCells(int size) {
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int column) {
        return getBoardCell(row, column).getSymbol() == null;
    }

    public void update(BoardCell move) {
        getBoardCell(move.getRow(), move.getColumn()).setSymbol(move.getSymbol());
    }

    private BoardCell getBoardCell(int row, int column) {
        return cells.get(row).get(column);
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                GameSymbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }

    public List<BoardCell> getEmptyCells(){
        //Itreate over the cells
        //Filter out empty cells;
        return cells.stream()
                .flatMap(List::stream)
                .filter( c -> c.getSymbol() == null)
                .toList();
    }
}
//
//import java.util.Collections;
//import java.util.List;
//
//public class Board {
//    private int size;
//    private List<List<BoardCell>> cells;
//
//    public Board(int size) {
//        this.size = size;
//        this.cells = initialiseCells(size);
//    }
//
//    private List<List<BoardCell>> initialiseCells(int size) {
//        List<BoardCell> firstRow = Collections.nCopies(size,new BoardCell());
//        return Collections.nCopies(size,firstRow);
//    }
//
//    public List<List<BoardCell>> getCells() {
//        return cells;
//    }
//
//    public boolean isEmpty(int row, int col) {
//        return cells.get(row).get(col) != null;
//    }
//    public void update(BoardCell move) {
//        printBoard();
//        cells.get(move.getRow()).get(move.getColumn()).setSymbol(move.getSymbol());
//        System.out.println();
//        printBoard();
//    }
//
//    public void printBoard() {
//        for (int i = 0; i < cells.size(); ++i) {
//            for (int j = 0; j < cells.size(); ++j) {
//                GameSymbol symbol = cells.get(i).get(j).getSymbol();
//
//                if (symbol == null) {
//                    System.out.printf(" | - | ");
//                } else {
//                    System.out.printf(" | " + symbol + " | ");
//                }
//            }
//            System.out.printf("\n");
//        }
//    }
//
//    public List<BoardCell> getEmptyCells(){
//        //Itreate over the cells
//        //Filter out empty cells;
//        return cells.stream()
//                .flatMap(List::stream)
//                .filter( c -> c.getSymbol() == null)
//                .toList();
//    }
//}
//
