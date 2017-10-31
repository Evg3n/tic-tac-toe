package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 * <p>
 * Checks if there is a column containing three of a kind(three X or O).
 */
public class ColumnCondition implements Condition {
    @Override
    public boolean isMet(Grid grid) {
        char[][] playBoard = grid.getGrid();

        boolean result = false;
        for (int i = 0; i < Grid.SIZE; i++) {
            if (grid.getColumnFreeCellsCount()[i] == 0) {
                char firstChar = playBoard[0][i];
                for (int j = 1; j < Grid.SIZE; j++) {
                    if (firstChar != playBoard[j][i]) {
                        result = false;
                        break;
                    }
                    result = true;
                }
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }
}