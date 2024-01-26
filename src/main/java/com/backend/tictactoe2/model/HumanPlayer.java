package com.backend.tictactoe2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.Scanner;

@Setter
@Getter
//Using toBuilder requires that all superclasses also have toBuilder = true
@SuperBuilder(toBuilder = true)
public class HumanPlayer extends Player{
    //flyweight design pattern as human player can play in multiple tab so ensure that same user is not repeated
    private User user;
    public HumanPlayer(User user, Symbol symbol){
        super(symbol);
        this.user = user;
    }
    @Override
    public BoardCell play(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column");
        int row = sc.nextInt();
        int col = sc.nextInt();
        return new BoardCell(row,col,getSymbol());
    }
}
