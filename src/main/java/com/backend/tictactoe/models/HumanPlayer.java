package com.backend.tictactoe.models;

import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder
public class HumanPlayer extends Player {

    private User user;

    public HumanPlayer(User user,GameSymbol symbol){
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makemove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new BoardCell(row,col,getSymbol());

    }
//   private HumanPlayer(Builder builder){
//      super(builder);
//      user = builder.user;
//   }

    // Builder patten implementation
//    public static class Builder extends Player.Builder<Builder>{
//        private User user;
//
//        public Builder(User user){
//            this.user = user;
//        }
//        @Override
//        public Player build() {
//            return new HumanPlayer(this);
//        }
//        @Override
//        protected Builder self() {
//            return this;
//        }
//    }
}
