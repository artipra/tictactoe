package com.backend.tictactoe;

import com.backend.tictactoe.models.Board;
import com.backend.tictactoe.models.BoardCell;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TicTacToeTest {

	@Test
	public void testCreateGame() {
		//Game game = new Game();
	}

	@Test
	public void testCreateBoard(){
	Board board = new Board(3);
	int rowSize = board.getCells().size();

    assertEquals(3,rowSize,"If the constructor of board is called with n, it should creates n rows");
	int colSize = board.getCells().get(0).size();
	assertEquals(3,colSize,"If the constructor of board is called with n, it should creates n columns");

	}

}
