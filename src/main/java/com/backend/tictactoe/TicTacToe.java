package com.backend.tictactoe;


import com.backend.tictactoe.exception.InvalidSymbolException;
import com.backend.tictactoe.models.*;
import com.backend.tictactoe.strategy.playing.RandomPlayingStrategy;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

import java.net.UnknownServiceException;
import java.util.Scanner;

public class TicTacToe {

	private static final int BOARD_SIZE = 3;

	public static void main(String[] args) {
		//Ask for user input-- name,email and symbol
		System.out.println("Welcome to TicTacToe");
		HumanPlayer humanPlayer = getUserInput();
		// create game
		Game game = createGame(humanPlayer);
		//Initialise the bot player
       // start game
		game.start();
		// Assign the first player
		//start playing game
		while(game.getStatus() == GameStatus.IN_PROGRESS){
			Player player = game.getNextPlayer();
			System.out.println("Next Player: "+player.getSymbol());
            game.makemove();
			game.getBoard().printBoard();
		}
		if(game.getStatus() == GameStatus.FINSIHED){
			System.out.println("Game won by player: "+ game.getWinner().getSymbol());
		}



	}

	private static Game createGame(HumanPlayer humanPlayer){
         return Game
				 .builder()
				 .withSize(BOARD_SIZE)
				 .withPlayer(humanPlayer)
				 .withPlayer(
						 BotPlayer.builder()
								 .level(GameLevel.EASY)
								 .playingStrategy(new RandomPlayingStrategy())
								 .symbol(decideBotSymbol(humanPlayer.getSymbol()))
								 .build()
				           )
				 .build();
	}

	private static GameSymbol decideBotSymbol(GameSymbol gameSymbol) {
		if(gameSymbol == GameSymbol.O) return GameSymbol.X;
		return GameSymbol.O;
	}

	private static HumanPlayer getUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter email");
		String email = sc.nextLine();
		System.out.println("Enter symbol :(O or X) ");
		GameSymbol symbol;
		try{
			symbol = GameSymbol.valueOf(sc.nextLine());
		}
		catch (IllegalArgumentException e){
			throw new InvalidSymbolException("Invalid symbol: Use O or X");
		}
        User user = new User(name,email,null);
		return new HumanPlayer(user,symbol);
	}

}
