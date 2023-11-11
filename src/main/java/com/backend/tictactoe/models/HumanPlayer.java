package com.backend.tictactoe.models;

public class HumanPlayer extends Player {

    private User user;

    @Override
    public BoardCell makemove(Board board) {
        return null;
    }
   private HumanPlayer(Builder builder){
      super(builder);
      user = builder.user;
   }

    // Builder patten implementation
    public static class Builder extends Player.Builder<Builder>{
        private User user;

        public Builder(User user){
            this.user = user;
        }
        @Override
        public Player build() {
            return new HumanPlayer(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
}
