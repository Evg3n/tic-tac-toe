package com.rubiconproject.tictactoe.condition;

import com.rubiconproject.tictactoe.Grid;

/**
 * Created by Yauheni Yudzitski <yauheni.yudzitski@gmail.com>
 */
public class RowCondition implements Condition {
    @Override
    public boolean isMet(Grid grid) {
        char[][] playBoard = grid.getGrid();

        boolean result = false;
        for (int i = 0; i < Grid.SIZE; i++) {
            if (grid.getRowFreeCellsCount()[i] == 0) {
                char firstChar = playBoard[i][0];
                for (int j = 1; j < Grid.SIZE; j++) {
                    if (firstChar != playBoard[i][j]) {
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