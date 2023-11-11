package com.backend.tictactoe;

import com.backend.tictactoe.models.*;
import com.backend.tictactoe.strategy.playing.PlayingStrategy;
import com.backend.tictactoe.strategy.playing.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TicTacToeTest {
     private static final int BOARD_SIZE = 3;
	@Test
	public void testCreateGame() {
//		creating game object without builder pattern
//		Board board = new Board(BOARD_SIZE);
//		Player humanPlayer = new HumanPlayer(GameSymbol.X,new User());
//		Player botPlayer = new BotPlayer(GameSymbol.X, GameLevel.EASY, new RandomPlayingStrategy());
//		Game game = new Game(board,List.of(humanPlayer,botPlayer), GameStatus.IN_PROGRESS);
		Game game = Game.builder()
				.withSize(BOARD_SIZE)
				.withPlayer(new HumanPlayer.Builder(new User()).withSymbol(GameSymbol.O).build())
				.withPlayer(new BotPlayer.Builder(GameLevel.EASY, new RandomPlayingStrategy()).withSymbol(GameSymbol.X).build())
				.build();
        assertEquals(2,game.getPlayers().size(),"If Game is created fine, then player size is 2");


	}

	@Test
	public void testCreateBoard(){
	Board board = new Board(BOARD_SIZE);
	int rowSize = board.getCells().size();

    assertEquals(3,rowSize,"If the constructor of board is called with n, it should creates n rows");
	int colSize = board.getCells().get(0).size();
	assertEquals(3,colSize,"If the constructor of board is called with n, it should creates n columns");

	}

}
