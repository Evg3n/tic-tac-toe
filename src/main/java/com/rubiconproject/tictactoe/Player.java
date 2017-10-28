package com.rubiconproject.tictactoe;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class Player {
    private char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public boolean makeMove(Grid grid, Scanner sc) throws NoSuchElementException {
        try {
            int x = sc.nextInt();
            int y = sc.nextInt();

            return grid.setCell(x, y, mark);
        } catch (InputMismatchException e) {
            return false;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No more data in the input.");
        }
    }
}