package com.backend.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players = new ArrayList();
    private GameStatus status;

    public Game(Board board, List<Player> players, GameStatus status) {
        this.board = board;
        this.players = players;
        this.status = status;
    }

    public void start(){}
    public void makemove(){}

    private Player checkWinner(){ return null;}
    private boolean checkDraw(){ return false;}
}
