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
 */
public class TicTacToeFactory {
    public static TicTacToe getTicTacToe() {
        List<Condition> stopGameConditions = new ArrayList<>();

        stopGameConditions.add(new RowCondition());
        stopGameConditions.add(new ColumnCondition());
        stopGameConditions.add(new LeftDiagonalCondition());
        stopGameConditions.add(new RightDiagonalCondition());

        stopGameConditions.add(new NoMovesLeftCondition());

        return getTicTacToe(stopGameConditions);
    }

    public static TicTacToe getTicTacToe(List<Condition> stopGameConditions) {
        Grid grid = new Grid();

        Player firstPlayer = new Player('X');
        Player secondPlayer = new Player('O');

        return new TicTacToe(grid, firstPlayer, secondPlayer, stopGameConditions, new Scanner(System.in));
    }
}