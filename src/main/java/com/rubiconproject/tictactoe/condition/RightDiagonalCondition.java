package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class RightDiagonalCondition implements Condition {
    @Override
    public boolean isMet(Grid grid) {
        char[][] playBoard = grid.getGrid();

        for (int i = 0; i < Grid.SIZE; i++) {
            if (playBoard[i][Grid.SIZE - i - 1] == '_') {
                return false;
            }
        }

        boolean result = false;
        char firstChar = playBoard[0][Grid.SIZE - 1];
        for (int i = 1; i < Grid.SIZE; i++) {
            if (firstChar != playBoard[i][Grid.SIZE - i - 1]) {
                result = false;
                break;
            }
            result = true;
        }

        return result;
    }
}