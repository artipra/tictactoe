package com.backend.tictactoe2.strategy.playing;



import com.backend.tictactoe2.model.BoardCell;
import com.backend.tictactoe2.model.Board;

import java.util.List;

public class DefaultStrategy implements PlayingStrategy{
    @Override
    public BoardCell makeMove(Board board) {
        List< BoardCell> emptyCells = board.getEmptyCells();
//       generate a random index for the cells
        int randomIdx = (int)(Math.random()*emptyCells.size());
         BoardCell boardCell = emptyCells.get(randomIdx);
//        board.printBoard();//to test
        return new BoardCell(boardCell.getRow(),boardCell.getCol());
    }
}
