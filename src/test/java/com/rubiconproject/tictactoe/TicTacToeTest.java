package com.rubiconproject.tictactoe;

import com.rubiconproject.tictactoe.condition.*;
import com.rubiconproject.tictactoe.exception.GameInterruptedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class TicTacToeTest {
    private Grid grid;
    private Player firstPlayer;
    private Player secondPlayer;
    private List<Condition> stopGameConditions;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        grid = new Grid();

        firstPlayer = new Player('X');
        secondPlayer = new Player('O');

        stopGameConditions = new ArrayList<>();

        stopGameConditions.add(new RowCondition());
        stopGameConditions.add(new ColumnCondition());
        stopGameConditions.add(new LeftDiagonalCondition());
        stopGameConditions.add(new RightDiagonalCondition());

        stopGameConditions.add(new NoMovesLeftCondition());
    }

    @Test
    public void gameEndsWithNoMovesLeft() {
        TicTacToe game = new TicTacToe(grid, firstPlayer, secondPlayer, stopGameConditions,
                new Scanner("1 1 0 0 0 2 2 0 1 0 1 2 0 1 2 1 2 2"));

        game.play();

        String expectedGrid =
                "O X X" + System.lineSeparator() + "X X O" + System.lineSeparator() + "O O X";
        Assert.assertTrue(expectedGrid.equals(game.getGrid().toString()));
    }

    @Test
    public void gameEndsWhenFirstPlayerWins() {
        TicTacToe game = new TicTacToe(grid, firstPlayer, secondPlayer, stopGameConditions,
                new Scanner("1 1 2 1 2 0 2 2 0 2"));

        game.play();

        String expectedGrid =
                "_ _ X" + System.lineSeparator() + "_ X _" + System.lineSeparator() + "X O O";
        Assert.assertTrue(expectedGrid.equals(game.getGrid().toString()));
    }

    @Test
    public void gameEndsWhenSecondPlayerWins() {
        TicTacToe game = new TicTacToe(grid, firstPlayer, secondPlayer, stopGameConditions,
                new Scanner("1 1 2 0 2 2 0 0 0 2 1 0"));

        game.play();

        String expectedGrid =
                "O _ X" + System.lineSeparator() + "O X _" + System.lineSeparator() + "O _ X";
        Assert.assertTrue(expectedGrid.equals(game.getGrid().toString()));
    }

    @Test
    public void throwsExceptionWhenInputEnds() {
        expectedException.expect(GameInterruptedException.class);
        expectedException.expectMessage("No more data in the input.");

        TicTacToe game = new TicTacToe(grid, firstPlayer, secondPlayer, stopGameConditions,
                new Scanner("1 1"));

        game.play();
    }
}