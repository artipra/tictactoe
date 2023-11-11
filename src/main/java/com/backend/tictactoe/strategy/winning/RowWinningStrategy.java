package com.backend.tictactoe.strategy.winning;

import com.backend.tictactoe.models.Board;
import com.backend.tictactoe.models.BoardCell;
import com.backend.tictactoe.models.GameSymbol;

import java.util.List;

public class RowWinningStrategy implements  WinningStrategy{


    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
            for(List<BoardCell> rows : board.getCells()){
                boolean isWinner = true;
                for(BoardCell row : rows){
                    if(row.getSymbol() != symbol)
                    {
                        isWinner = false;break;
                    }
                }
                if(isWinner) return true;
            }
            return false;
        }
}
