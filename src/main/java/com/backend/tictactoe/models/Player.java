package com.backend.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Player {

    private GameSymbol symbol;

    public abstract BoardCell makemove(Board board);

    //    Player(Builder<?> builder){
//        symbol = builder.symbol;
//    }

//    abstract static class Builder<T extends Builder<T>>{
//       GameSymbol symbol;
//        public T withSymbol(GameSymbol symbol){
//            this.symbol = symbol;
//            return self();
//        }
//
//        abstract Player build();
//        protected abstract T self();
//    }
}
