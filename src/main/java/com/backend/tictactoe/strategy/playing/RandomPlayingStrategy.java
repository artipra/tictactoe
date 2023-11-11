package com.backend.tictactoe.strategy.playing;

import com.backend.tictactoe.models.Board;
import com.backend.tictactoe.models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
       List<BoardCell> emptyCells = board.getEmptyCells();
//       generate a random index for the cells
        int randomIdx = (int)(Math.random()*emptyCells.size());
        BoardCell boardCell = emptyCells.get(randomIdx);
//        board.printBoard();//to test
       return new BoardCell(boardCell.getRow(),boardCell.getColumn());
    }
}
