package com.backend.tictactoe2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@Getter
public abstract class Player{

    public Symbol symbol;
    public abstract BoardCell play(Board board);
}
