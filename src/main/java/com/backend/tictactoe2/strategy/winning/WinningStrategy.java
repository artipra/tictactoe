package com.backend.tictactoe2.strategy.winning;

import com.backend.tictactoe2.model.Board;
import com.backend.tictactoe2.model.Player;
import com.backend.tictactoe2.model.Symbol;

import java.util.List;

public interface WinningStrategy {

    public boolean checkWinner(Board board, Symbol symbol);
}
