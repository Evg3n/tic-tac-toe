package com.rubiconproject.tictactoe;

import com.rubiconproject.tictactoe.condition.Condition;
import com.rubiconproject.tictactoe.exception.GameInterruptedException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class TicTacToe {
    private Grid grid;

    private Player firstPlayer;
    private Player secondPlayer;
    private List<Condition> stopGameConditions;
    private Scanner scanner;

    public TicTacToe(Grid grid, Player firstPlayer, Player secondPlayer, List<Condition> stopGameConditions,
                     Scanner scanner) {
        this.grid = grid;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.stopGameConditions = stopGameConditions;
        this.scanner = scanner;
    }

    public void play() {
        System.out.println("Start the game by entering coordinates in range 0-2 to mark the cell.");
        System.out.println(grid.toString() + System.lineSeparator());

        int movesCount = 0;
        while (!isAnyConditionMet()) {
            try {
                boolean moveResult =
                        movesCount % 2 == 0 ? firstPlayer.makeMove(grid, scanner) :
                                secondPlayer.makeMove(grid, scanner);

                if (moveResult) {
                    movesCount++;
                    System.out.println(grid.toString() + System.lineSeparator());
                } else {
                    printErrorMessage();
                }
            } catch (NoSuchElementException e) {
                throw new GameInterruptedException(e);
            }
        }

        printFinalResult();
    }

    private boolean isAnyConditionMet() {
        for (Condition c : stopGameConditions) {
            if (c.isMet(grid)) {
                return true;
            }
        }

        return false;
    }

    private void printErrorMessage() {
        System.out.println(
                "Error occurred while making your move." + System.lineSeparator() + "Please make sure:" +
                        System.lineSeparator() + "\t- cell is empty;" + System.lineSeparator() +
                        "\t- x and y are in range 0-2.");
    }

    private void printFinalResult() {
        System.out.println("Game over!");
        System.out.println("Final board:");
        System.out.println(grid.toString());
    }

    public Grid getGrid() {
        return grid;
    }
}