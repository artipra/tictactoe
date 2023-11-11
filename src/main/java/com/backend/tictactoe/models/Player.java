package com.backend.tictactoe.models;

public abstract class Player {

    private GameSymbol symbol;

    Player(Builder<?> builder){
        symbol = builder.symbol;
    }

    public GameSymbol getSymbol() {
        return symbol;
    }

    public abstract BoardCell makemove(Board board);

    abstract static class Builder<T extends Builder<T>>{
       GameSymbol symbol;
        public T withSymbol(GameSymbol symbol){
            this.symbol = symbol;
            return self();
        }

        abstract Player build();
        protected abstract T self();
    }
}
