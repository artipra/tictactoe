package com.backend.tictactoe2.model;

import com.backend.tictactoe2.exception.InvalidMoveException;
import com.backend.tictactoe2.strategy.winning.RowWinningStrategy;
import com.backend.tictactoe2.strategy.winning.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Game {

    private Board board;
    private List<Player> players = new ArrayList<>();
    private static final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private int nextPlayer = 0;
    private GameStatus status;
    private Player winner;
    private List<WinningStrategy> strategies = List.of(new RowWinningStrategy());
    public void start(){
       nextPlayer = (int)(Math.random()*players.size());
       status = GameStatus.IN_PROGRESS;
    }

    public void makeMove(){
        BoardCell move = getNextMove();
        board.updateBoard(move);
        if(checkWinner(move.getSymbol())){
            status = GameStatus.FINSIHED;
            winner = getNextPlayer();
            return;
        }
        if(checkDraw()){
          status = GameStatus.DRAWN;
        }

        nextPlayer = (nextPlayer+1)% players.size();
    }

    private boolean checkWinner(Symbol symbol) {
        for( WinningStrategy strategy : strategies){
           boolean hasWinner = strategy.checkWinner(getBoard(),symbol);
           if(hasWinner) return true;
        }
        return false;
    }

    private boolean checkDraw() {
     boolean isDrawn = true;
       for(List<BoardCell> row : board.getCells()) {
           boolean rowCheck = false;
           for (BoardCell cell : row) {
               rowCheck = board.isEmpty(cell.getRow(), cell.getCol());
               if (rowCheck) {
                   return false;
               }
           }
           if (rowCheck) {
               return false;
           }
       }
        return isDrawn;
    }



    public Player getNextPlayer() {
        return players.get(nextPlayer);
    }

    private BoardCell getNextMove() {
        Player currentPlayer = players.get(nextPlayer);
        BoardCell move = currentPlayer.play(board);
        validateMove(move);
        return move;
    }

    private void validateMove(BoardCell move) {
        if(!board.isEmpty(move.getRow(),move.getCol()))
            throw new InvalidMoveException(move.getRow(),move.getCol());
    }

    public static Builder getbuilder(){
       return new Builder();
   }
   public static class Builder{

       private Game game;

        Builder(){
           this.game = new Game();
           this.game.board = new Board(3,3);
       }

       public Game build(){
           boolean isValid = validate();
           if(!isValid) throw new RuntimeException("Game is not valid");
           return this.game;
       }

       public Builder withDimension(int row, int col){
           this.game.setBoard(new Board(row,col));
           return this;
       }

       public Builder withPlayer(Player player){
           this.game.players.add(player);
           return this;
       }

       public boolean validate(){
        List<Player> players = this.game.getPlayers();
        if(players.size() > 2) return false;
        return true;
       }
    }

}
