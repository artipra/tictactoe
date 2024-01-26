package com.backend.tictactoe2;

import com.backend.tictactoe.models.GameSymbol;
import com.backend.tictactoe2.exception.InvalidSymbolException;
import com.backend.tictactoe2.model.*;
import com.backend.tictactoe2.strategy.playing.DefaultStrategy;

import java.util.Scanner;

public class TictactoeTest {
    static Game game;
    private static final int BOARD_SIZE = 3;
    public static void main(String[] args) {
      System.out.println("Welcome to tic tac toe");
      game = createGame(getUserInput());
      game.start();
      playGame();

    }

    private static void playGame() {
       while(game.getStatus() == GameStatus.IN_PROGRESS){
           Player player = game.getNextPlayer();
           System.out.println("Next Player "+player.symbol);
           game.makeMove();
           game.getBoard().printBoard();
       }

    }

    static Game createGame(HumanPlayer humanPlayer){

        BotPlayer bot = BotPlayer
                        .builder()
                        .symbol(decideBotSymbol(humanPlayer.getSymbol()))
                        .level(GameLevel.EASY)
                        .playingStrategy(new DefaultStrategy())
                        .build();
        Game game  = Game.getbuilder()
                .withPlayer(humanPlayer)
                .withPlayer(bot)
                .build();

        return game;
    }

    private static Symbol decideBotSymbol(Symbol gameSymbol) {
        if(gameSymbol == Symbol.O) return Symbol.X;
        return Symbol.O;
    }

    private static HumanPlayer getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        System.out.println("Enter symbol (O and X)");
        Symbol symbol;
        try{
            symbol = Symbol.valueOf(sc.nextLine());
        }
        catch(IllegalArgumentException e){
            throw new InvalidSymbolException();
        }

        User user = new User(name,email,null);
        return new HumanPlayer(user,symbol);

    }
}
