package com.backend.tictactoe.models;

import com.backend.tictactoe.strategy.playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer  extends Player{

    private GameLevel level;
    private PlayingStrategy playingStrategy;


    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStrategy playingStrategy) {
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makemove(Board board) {
        BoardCell boardCell =  playingStrategy.makeMove(board);
        boardCell.setSymbol(getSymbol());
        return boardCell;
    }

}
