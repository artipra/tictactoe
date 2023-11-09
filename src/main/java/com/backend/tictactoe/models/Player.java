package com.backend.tictactoe.models;

public abstract class Player {

    private GameSymbol symbol;


    public Player(GameSymbol symbol) {
        this.symbol = symbol;
    }
}
