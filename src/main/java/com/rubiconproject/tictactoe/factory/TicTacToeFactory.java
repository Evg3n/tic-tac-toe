package com.rubiconproject.tictactoe.factory;

import com.rubiconproject.tictactoe.Grid;
import com.rubiconproject.tictactoe.Player;
import com.rubiconproject.tictactoe.TicTacToe;
import com.rubiconproject.tictactoe.condition.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 * <p>
 * This class contains factory methods to create game instances.
 */
public class TicTacToeFactory {

    /**
     * Creates regular Tic Tac Toe game.
     *
     * @return regular Tic Tac Toe game
     */
    public static TicTacToe getTicTacToe() {
        List<Condition> stopGameConditions = new ArrayList<>();

        stopGameConditions.add(new RowCondition());
        stopGameConditions.add(new ColumnCondition());
        stopGameConditions.add(new LeftDiagonalCondition());
        stopGameConditions.add(new RightDiagonalCondition());

        stopGameConditions.add(new NoMovesLeftCondition());

        return getTicTacToe(stopGameConditions);
    }

    /**
     * Creates Tic Tac Toe game instance with regular players, grid size and shape but with custom rules to stop the game.
     *
     * @param stopGameConditions
     * @return Tic Tac Toe game with custom rules
     */
    public static TicTacToe getTicTacToe(List<Condition> stopGameConditions) {
        Grid grid = new Grid();

        Player firstPlayer = new Player('X');
        Player secondPlayer = new Player('O');

        return new TicTacToe(grid, firstPlayer, secondPlayer, stopGameConditions, new Scanner(System.in));
    }
}