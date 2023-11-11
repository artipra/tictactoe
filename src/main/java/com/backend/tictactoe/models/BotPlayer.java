package com.backend.tictactoe.models;

import com.backend.tictactoe.strategy.playing.PlayingStrategy;

public class BotPlayer  extends Player{

    private GameLevel level;
    private PlayingStrategy playingStrategy;


    public BotPlayer(Builder builder) {
        super(builder);
        this.level = builder.level;
        this.playingStrategy = builder.playingStrategy;
    }

    @Override
    public BoardCell makemove(Board board) {
        return playingStrategy.makeMove(board);
    }

    public static class Builder extends Player.Builder<Builder>{
        private GameLevel level;
        private PlayingStrategy playingStrategy;

        public Builder(GameLevel level,PlayingStrategy playingStrategy){
            this.level = level;
            this.playingStrategy = playingStrategy;
        }
        @Override
        public Player build() {
            return new BotPlayer(this);
        }
        @Override
        protected BotPlayer.Builder self() {
            return this;
        }


    }

}
