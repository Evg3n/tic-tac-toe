package com.rubiconproject.tictactoe;

import java.util.StringJoiner;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class Grid {
    public static final int SIZE = 3;
    public static final char EMPTY_CELL = '_';

    private static final char CELL_SEPARATOR = ' ';

    private char[][] grid;
    private int freeCellsCount;
    private int[] rowFreeCellsCount;
    private int[] columnFreeCellsCount;

    public Grid() {
        grid = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }

        freeCellsCount = SIZE * SIZE;
        rowFreeCellsCount = new int[SIZE];
        columnFreeCellsCount = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            rowFreeCellsCount[i] = SIZE;
            columnFreeCellsCount[i] = SIZE;
        }
    }

    public boolean setCell(int x, int y, char mark) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE || grid[x][y] != EMPTY_CELL) {
            return false;
        }

        grid[x][y] = mark;

        freeCellsCount--;
        rowFreeCellsCount[x]--;
        columnFreeCellsCount[y]--;
        return true;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getFreeCellsCount() {
        return freeCellsCount;
    }

    public int[] getRowFreeCellsCount() {
        return rowFreeCellsCount;
    }

    public int[] getColumnFreeCellsCount() {
        return columnFreeCellsCount;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (int i = 0; i < SIZE; i++) {
            StringJoiner rowJoiner = new StringJoiner(String.valueOf(CELL_SEPARATOR));
            for (int j = 0; j < SIZE; j++) {
                rowJoiner.add(String.valueOf(grid[i][j]));
            }
            joiner.add(rowJoiner.toString());
        }

        return joiner.toString();
    }
}