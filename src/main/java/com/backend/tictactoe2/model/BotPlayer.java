package com.backend.tictactoe2.model;

import com.backend.tictactoe2.strategy.playing.PlayingStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder(toBuilder = true)
public class BotPlayer extends Player{
    private GameLevel level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(GameLevel level, PlayingStrategy playingStrategy,Symbol symbol){
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell play(Board board) {
        BoardCell cell = playingStrategy.makeMove(board);
        cell.setSymbol(getSymbol());
        return cell;
    }
}
