package com.backend.tictactoe2.strategy.winning;

import com.backend.tictactoe2.model.Board;
import com.backend.tictactoe2.model.BoardCell;
import com.backend.tictactoe2.model.Player;
import com.backend.tictactoe2.model.Symbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {
        for(List<BoardCell> rows : board.getCells()){
           boolean isWinner = true;
           for(BoardCell row : rows){
               if(row.getSymbol() != symbol){
                   isWinner = false;break;
               }
           }
            if(isWinner) return true;
        }
        return false;
    }
}
