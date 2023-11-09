package com.backend.tictactoe.models;

public class BotPlayer  extends Player{

    private GameLevel level;

    public BotPlayer(GameSymbol symbol, GameLevel level) {
        super(symbol);
        this.level = level;
    }
}
