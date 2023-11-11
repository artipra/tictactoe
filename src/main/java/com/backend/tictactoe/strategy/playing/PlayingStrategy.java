package com.backend.tictactoe.strategy.playing;

import com.backend.tictactoe.models.Board;
import com.backend.tictactoe.models.BoardCell;

public interface PlayingStrategy {

   BoardCell makeMove(Board board);
}
