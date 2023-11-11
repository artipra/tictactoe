package com.backend.tictactoe.models;

import com.backend.tictactoe.exception.InvalidPlayerException;
import com.backend.tictactoe.exception.invalidMoveException;
import com.backend.tictactoe.strategy.winning.RowWinningStrategy;
import com.backend.tictactoe.strategy.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Game {
    private static final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private Board board;
    private List<Player> players = new ArrayList();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private Player winner;

    private List<WinningStrategy> strategies = List.of(new RowWinningStrategy());
    private Game(){}

    public static Builder builder(){
        return new Builder();
    }
    public Game(Board board, List<Player> players, GameStatus status) {
        this.board = board;
        this.players = players;
        this.status = status;
    }

    public Player getWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void start(){
    nextPlayerIndex = (int)(Math.random()*players.size());
    status = GameStatus.IN_PROGRESS;
    }
    public void makemove(){
        // Get the next player
        //Get the next move from the player
        //make move
        //Bot playing strategy
        // user input scanner
        // validate the move - check if cells was already filled
        // update the board
        BoardCell move = getNextMove();
//        board.printBoard();
//        System.out.println();
        board.update(move);
      //  board.printBoard();
       // System.out.println();
        // check win
        if(checkWinner(move.getSymbol())){
            status = GameStatus.FINSIHED;
            winner = getNextPlayer();
            return;
        }
        //check draw
        if(checkDraw()){
           status = GameStatus.DRAWN;
        }

        // update the next player
        nextPlayerIndex = (nextPlayerIndex+1) % players.size();
    }

    private BoardCell getNextMove(){
        Player player = players.get(nextPlayerIndex);
        BoardCell move = player.makemove(board);
        validateMove(move);
        return move;
    }

    private void validateMove(BoardCell move){
        if(!board.isEmpty(move.getRow(),move.getColumn())){
            throw new invalidMoveException(move.getRow(),move.getColumn());
        }
    }
    private boolean checkWinner(GameSymbol symbol){
        for(WinningStrategy strategy : strategies){
            boolean hasWinner = strategy.checkWinner(getBoard(),symbol);
            if(hasWinner) return true;
        }
       return false;
    }



    private boolean checkDraw(){ return false;}

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }


    //Builder pattern
    // Create static inner class
    public static class Builder{

        private Game game;
        private Builder(){
            game = new Game();
        }

        public Builder withSize(int size){
        this.game.board = new Board(size);
        return this;
        }
       public Builder withPlayer(Player player){
            game.getPlayers().add(player);
            return this;
       }

       public Game build(){
            boolean isValid = validate();
            if(!isValid){
                throw new InvalidPlayerException();
            }
            Game neGame = new Game();
            neGame.players = game.players;
            neGame.board = game.board;
            neGame.status = DEFAULT_STATUS;
            return neGame;
       }

       private boolean validate(){
            List<Player> players = game.players;
            if(players.size() < PLAYER_COUNT) return false;
            //symbol are unique
           Set<GameSymbol> symbols = players.stream().map(Player::getSymbol).collect(Collectors.toSet());
           return symbols.size() == PLAYER_COUNT;
       }

    }
}
