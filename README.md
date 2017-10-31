# Tic Tac Toe

## Task

JAVA CODING TASK: Implement standard game of TicTacToe
- Two players: X and O;
- Players alternate in turn (as in standard TicTacToe);
- 3x3 board;
- Default "Win Conditions":  3 in a row, a column or diagonally.

Further Directives
- Simple UI:  stdout text prompt to get the (x,y) for each move from stdin.
     Keep UI simple and dumb as possible while still 
     letting players choose their moves.
     UI will be used primarily for demonstration/validation.
     The UI is not the focus of this task.
     
- Choose a design that would allow easy addition of
   alternate games whkere just the "win conditions" would change.
   The size/shape of the board and the order of play do not change
   with the diffferent versions of the game...  just the win
   conditions.
   
- While correct code is a goal, it is not the only goal ... We are looking
   for product level appropriate architecture, design, implementation
   and testing that meets the spec.
   Treat this code a component of a larger system (excluding
   the UI).
   
- Be sure to communicate a coherent functional design.

Questions are good....  if you need clarification of this
description... better to ask than assume.

Be prepared to defend your choices and demonstrate your result.

## General information

Wiki: https://en.wikipedia.org/wiki/Tic-tac-toe

## Design

The application involves several important peaces:
- There is a grid where the game happens;
- There are two players involved in the game;
- There are rules of the game to determine when one of players win or it is a draw(no more moves left to make).

### Grid

The grid is represented by the class `com.rubiconproject.tictactoe.Grid`. 
It has a two-dimensional array to represents state of the grid. An empty cell contains '_' symbol.

Also there is some meta data to check the state of the grid more efficiently. For example, it has information of 
how many empty cells left in the entire grid and also it has same information for each row and column.

### Player

Player is an actor in the game who marks some cell in the grid(represented by `com.rubiconproject.tictactoe.Player` class).
To do so player reads two coordinates from the input. 
Coordinates should be in range 0-2 inclusive. Knowing which mark player owns he marks the cell in the grid with it. 
For cell to be set successfully it should be empty. Otherwise player should enter another coordinates to proceed with his turn.

### Rules

According to the task the solution should be able to produce Tic Tac Toe game 
with custom rules without changing the rest parts of the game.
To do so rules should be represented in the game by higher level abstraction 
(`com.rubiconproject.tictactoe.condition.Condition` interface). So now implementing this interface we can add custom rules to the game.

There are regular rules already implemented:
- `com.rubiconproject.tictactoe.condition.RowCondition`
- `com.rubiconproject.tictactoe.condition.ColumnCondition`
- `com.rubiconproject.tictactoe.condition.LeftDiagonalCondition`
- `com.rubiconproject.tictactoe.condition.RightDiagonalCondition`
- `com.rubiconproject.tictactoe.condition.NoMovesLeftCondition`

### The game

Business logic of the Tic Tac Toe game is implemented in the class: `com.rubiconproject.tictactoe.TicTacToe`.
This class is a controller of the game. It controls which player should make his turn next and when to stop the game.
And also handles any errors like player tries to set a cell which already has been set by another player.

As task states the solution should provide ability to create regular game and the game with custom rules.
For that purpose there two factory methods:
- `com.rubiconproject.tictactoe.factory.TicTacToeFactory.getTicTacToe()` - creates regular Tic Tac Toe game;
- `com.rubiconproject.tictactoe.factory.TicTacToeFactory.getTicTacToe(java.util.List<com.rubiconproject.tictactoe.condition.Condition>)` - creates Tic Tac Toe game with custom rules.

#### Running the regular Tic Tac Toe

From IDE: Run the class `com.rubiconproject.Main`.

From CMD: `java -jar tic-tac-toe-1.0-SNAPSHOT.jar`.