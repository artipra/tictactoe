package com.backend.tictactoe2.strategy.playing;

import com.backend.tictactoe2.model.Board;
import com.backend.tictactoe2.model.BoardCell;

public interface PlayingStrategy {

    BoardCell makeMove(Board board);
}
