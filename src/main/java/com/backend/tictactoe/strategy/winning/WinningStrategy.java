package com.backend.tictactoe.strategy.winning;

import com.backend.tictactoe.models.Board;
import com.backend.tictactoe.models.GameSymbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, GameSymbol symbol);

}
