# Design Tic-Tac-Toe

## What is Tic-Tac-Toe?

TicTacToe is a 2 player game played on a 3 x 3 board. Each player is allotted a symbol (one X and one O). Initially, the board is empty. Alternatively, each player takes a turn and puts their symbol at any empty slot. The first player to get their symbol over a complete row OR a complete column OR a diagonal wins.

You can play the game within Google Search by just searching for “tictactoe”!

![TicTacToe](https://www.tuitec.com/wp-content/uploads/2016/08/morpion-640x411.jpg)


## Expectations
* The code should be working and functionally correct
* Good software design practices should be followed:
* Code should be modular, readable, extensible
* Separation of concern should be addressed
* Project structured well across multiple files/ packages
* Write unit tests
* No need of GUI


## Requirements gathering

What are some questions you would ask to gather requirements?
```
1 what would be board size ?
2 Will game between human vs bot or human vs human ?
3 what would be winning conditions ?
4 will history maintain for human player ?
5 Can players be more than 2 in future ?
6 will board size be 3*3 fixed or can be n*n ?

```

## Requirements
What will be 10 requirements of the system, according to you?
Do not worry about the correctness of the requirements, just write down whatever comes to your mind.
Your job is not to generate the requirements, but get better at understanding problem statements and anticipating the functionalities your application might need.
```
1 Board can be of n*n size .
2 There can be 2 players .
3 if board is full and no player win then game iss drawn .
4 Any player can start game ramdomly .
5 Bot will have difficultly levels .
6 human can choose difficultly of the game .
7 Each player will be allotted a symbol.
8 The symbol can be O and X
9 Each human player will have profile image,email and name.
10 Any random player can start the game.
11 Then player can play alternatively.
```

## Use case diagrams

Are the requirements clear enough to define use cases?
If not, try to think of the actors and their interactions with the system.

### Actors
What would be the actors in this system?
```
Human player
Bot Player
```
### Use cases
What would be the use cases i.e. the interactions between the actors and the system?

#### Actor 1

Name of the actor - `human player `

Use cases:
```
1. Create profile
2. Select symbol 
3. play game
4. check game is over
```
#### Actor 2

Name of the actor - `Bot player `
Use cases:
```
1. play game
2. check game is over
3. 
4. 
```

#### Actor 3

Name of the actor - ` `
Use cases:
```
1. 
2. 
3. 
4. 
```
Add more actors and their use cases as needed.

**Create a use case diagram for the system.**

```
@startuml
left to right direction

actor Humanplayer
actor Botplayer

rectangle Game {
    usecase "check if won/drawn" as checkgamewin
    usecase "create profile" as profile
    usecase "select symbol" as symbol
    usecase "play game" as playgame
 

    (playgame) .> (checkgamewin) : includes
}

Humanplayer --> profile
Humanplayer --> symbol
Humanplayer --> playgame
Botplayer --> playgame
@enduml
```

## Class diagram

What will be the major classes and their attributes?

```
Entities and their attributes 
Game
 Board
 Player
 
Board
 Cells

Cell
 x
 y
 symbol
 
Symbol
 0
 X

 
HumanPlayer
 Symbol
 User
 
User
 name
 image
 email
 
Bot 
 symbol
 difficulty level 
 
```

List down the cardinalities of the relationships between the classes.
```
```

Draw the class diagram.
```
classDiagram
  class Game {
    - Board board
    - Player[] players
    +startGame(Player[], int)
    +makeMove(PlayerId, int, int)
    +checkWinner(Board, Player[]) : Player
    +registerPlayer(Player)
  }

    class Board {
    -Cell[][] cells
    +Board(int size) : Board
  }

  class Cell {
    -int row
    -int column
    -Symbol symbol
  }

  class Player {
    <<abstract>>
    -Symbol symbol
    +play(Board) BoardCell
  }

  class HumanPlayer {
    -User user
    +play(Board) BoardCell
  }

  class User {
    -String name
    -String email
    -Byte[] profileImage
  }

  class BotPlayer {
    -Level difficultyLevel
    -MoveStrategy moveStrategy
    +play(Board) BoardCell
  }

    class MoveStrategy {
        <<interface>>
        +makeMove(Board) BoardCell
    }

    class RandomMoveStrategy {
        +makeMove(Board) BoardCell
    }

    class ClusteringMoveStrategy {
        +makeMove(Board) BoardCell
    }

    class MinimaxMoveStrategy {
        +makeMove(Board) BoardCell
    }

  Game "1" --* "*" Player
    Game "1" --* "1" Board
    Board "1" --* "*" Cell
  HumanPlayer "*" --o "1" User
  Player <|-- HumanPlayer
  Player <|-- BotPlayer
  BotPlayer "*" --o "1" MoveStrategy
  MoveStrategy <|-- RandomMoveStrategy
  MoveStrategy <|-- ClusteringMoveStrategy
  MoveStrategy <|-- MinimaxMoveStrategy

```